package roboguy99.chemistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoaderRegistry;
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
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.block.BlockCompoundCreator;
import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.compound.CompoundNames;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;
import roboguy99.chemistry.item.element.render.ModelLoader;
import roboguy99.chemistry.network.CommonProxy;
import roboguy99.chemistry.network.packet.CompoundCreate;
import roboguy99.chemistry.network.packet.CompoundCreate.CompoundCreateHandle;
import roboguy99.chemistry.network.packet.ItemDelete;
import roboguy99.chemistry.network.packet.ItemDelete.ItemDeleteHandle;
import roboguy99.chemistry.tileentity.TileEntities;

/**
 * Main class. Handles mod initialisation.
 * 
 * @author Roboguy99uy99
 * 
 */
@Mod(modid = Chemistry.modID, version = Chemistry.modVersion, name = Chemistry.name)
public class Chemistry 
{
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry";

	public static final Logger logger = LogManager.getLogger("Chemistry");

	@SidedProxy(clientSide = "roboguy99.chemistry.network.ClientProxy", serverSide = "roboguy99.chemistry.network.CommonProxy")
	public static CommonProxy proxy;
	public static SimpleNetworkWrapper networkWrapper;

	public static Chemistry instance;
	
	private static BlockCompoundCreator blockCompoundCreator;
	
	public static String CONFIG_DIR;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) // Pre-initialisation loading
	{
		logger.info("Pre-initialising");
		this.instance = this;
		
		this.CONFIG_DIR = event.getModConfigurationDirectory() + "/Chemistry";
		
		new Elements();
		
		

		proxy.registerProxies();
		
		this.networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("hotbarBag_inv");
		this.networkWrapper.registerMessage(CompoundCreateHandle.class, CompoundCreate.class, 0, Side.SERVER);
		this.networkWrapper.registerMessage(ItemDeleteHandle.class, ItemDelete.class, 1, Side.SERVER);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) // Initialisation loading
	{
		logger.info("Initialising");
		new Compound();
		new CompoundNames();
	
	this.blockCompoundCreator = new BlockCompoundCreator();
		new TileEntities();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{			
	}
	
	public static CreativeTabs tabElements = new CreativeTabs("tabElements") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Elements.getElement(EnumElement.CARBON);
	    }
	};
	public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(Chemistry.blockCompoundCreator);
	    }
	};
}	