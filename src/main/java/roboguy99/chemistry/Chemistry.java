package roboguy99.chemistry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import roboguy99.chemistry.api.CompoundNamer;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Elements.Element;
import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.api.Ores;
import roboguy99.chemistry.block.BlockCompoundCreator;
import roboguy99.chemistry.block.BlockOreProcessor;
import roboguy99.chemistry.block.ore.BlockOre;
import roboguy99.chemistry.handler.GuiHandler;
import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.network.CommonProxy;
import roboguy99.chemistry.network.packet.CompoundCreate;
import roboguy99.chemistry.network.packet.CompoundCreate.CompoundCreateHandle;
import roboguy99.chemistry.network.packet.ItemDelete;
import roboguy99.chemistry.network.packet.ItemDelete.ItemDeleteHandle;
import roboguy99.chemistry.tile.TileEntities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Main class. Handles mod initialisation.
 * 
 * @author Jake Stanger
 * 
 */
@Mod(modid = Chemistry.modID, version = Chemistry.modVersion, name = Chemistry.name)
public class Chemistry 
{
	// Mod data. Fallback if mc-mod.info fails to load.
	static final String modID = "chemistry";
	static final String modVersion = "0.0.0";
	public static final String name = "Chemistry";

	public static final Logger logger = LogManager.getLogger("Chemistry");
	
	public static String CONFIG_DIR;

	@SidedProxy(clientSide = "roboguy99.chemistry.network.ClientProxy", serverSide = "roboguy99.chemistry.network.CommonProxy")
	private static CommonProxy proxy;
	private static SimpleNetworkWrapper networkWrapper;

	public static Chemistry INSTANCE;
	
	private static BlockCompoundCreator blockCompoundCreator; //TODO Give this a proper home
	private static BlockOreProcessor blockOreProcessor;
	
	private static Compound compound;
	
	private static Ores ores;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event) // Pre-initialisation loading
	{
		logger.info("Pre-initialising");
		Chemistry.INSTANCE = this;
		
		Chemistry.CONFIG_DIR = event.getModConfigurationDirectory() + "/Chemistry/";
		
		new Elements();
		
		Chemistry.ores = new Ores(event);
		
		Chemistry.compound = new Compound();
		
		Chemistry.blockCompoundCreator = new BlockCompoundCreator();
		Chemistry.blockOreProcessor = new BlockOreProcessor();
		
		proxy.registerProxies();
		
		Chemistry.networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("chemisty");
		this.getNetworkWrapper().registerMessage(CompoundCreateHandle.class, CompoundCreate.class, 0, Side.SERVER);
		this.getNetworkWrapper().registerMessage(ItemDeleteHandle.class, ItemDelete.class, 1, Side.SERVER);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		//Client-side
		if(event.getSide() == Side.CLIENT)
		{
			//Textures
			ModelLoader.setCustomModelResourceLocation(Chemistry.compound, 0, new ModelResourceLocation("chemistry:compound", "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Chemistry.blockCompoundCreator), 0, new ModelResourceLocation("chemistry:blockCompoundCreator", "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Chemistry.blockOreProcessor), 0, new ModelResourceLocation("chemistry:blockOreProcessor", "inventory"));
		}
	}

	@EventHandler
	private void init(FMLInitializationEvent event) // Initialisation loading
	{
		logger.info("Initialising");
		new CompoundNamer();
	
		new TileEntities();
	}

	@EventHandler
	private void postInit(FMLPostInitializationEvent event) 
	{
		//this.generateTexturesForElements();
	}
	
	private void generateTexturesForElements()
	{
		for(ItemElement element : Elements.getElements())
		{
			if(element != null && !new File("generatedtextures" + element.getName() + "png").isFile()) 
			{
				String text = element.getSymbol();
				Group group = element.getGroup();
			
		        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		        Graphics2D g2d = img.createGraphics();
		        
		        Font font;
		        if(text.length() <= 2) font = new Font("Helvetica", Font.PLAIN, 45);
		        else font = new Font("Helvetica", Font.PLAIN, 32);
		        
		        int[] color = Group.getGroupColour(group).rgbCode;
		        Color colour = new Color(color[0], color[1], color[2]);
		        
		        g2d.setFont(font);
		        java.awt.FontMetrics fm = g2d.getFontMetrics();
		        g2d.dispose();
		
		        img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		        g2d = img.createGraphics();
		        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		        g2d.setColor(colour);
		        g2d.draw3DRect(0, 0, img.getWidth(), img.getHeight(), false);
		        g2d.fill3DRect(0, 0, 64, 64, false);
		        
		        g2d.setFont(font);
		        fm = g2d.getFontMetrics();
		        g2d.setColor(colour.brighter().darker().brighter()); //This gives a colour slightly different to a single brighter
		        
		        g2d.drawString(text, 32- fm.stringWidth(text)/2, 32+ fm.getDescent() + 5);
		        g2d.dispose();
		        try 
		        {
		            ImageIO.write(img, "png", new File("../generatedtextures/" + element.getName() + ".png"));
		        } 
		        catch (IOException ex) 
		        {
		            ex.printStackTrace();
		        }
			}
		}
	}
	
	/**
	 * Get the configuration file for the mod.
	 * This will be placed in /config/Chemistry/modid.cfg
	 * @param modId The name of the configuration file to generate
	 * @return The configuration for the given modid
	 */
	public static Configuration getConfig(String modId)
	{
		return new Configuration(new File(Chemistry.CONFIG_DIR + modId + ".cfg"));
	}
	
	/**
	 * Get the network wrapper. This is used for sending/receiving packets.
	 * @return the networkWrapper
	 */
	public SimpleNetworkWrapper getNetworkWrapper()
	{
		return networkWrapper;
	}
	
	/**
	 * Returns the compound item instance
	 * @return
	 */
	public static Compound getCompound()
	{
		return Chemistry.compound;
	}

	/**
	 * The creative tab for elements
	 */
	public static CreativeTabs tabElements = new CreativeTabs("tabElements") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Element.CARBON.getElement();
	    }
	};
	/**
	 * The creative tab for machines
	 */
	public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(Chemistry.blockCompoundCreator);
	    }
	};
	
	/**
	 * The creative tab for ores
	 */
	public static CreativeTabs tabOres = new CreativeTabs("tabOre") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        Random random = new Random();
	        List<BlockOre> ores = Ores.INSTANCE.getOres();
	    	return Item.getItemFromBlock(ores.get(random.nextInt(ores.size())));
	    }
	};
}	