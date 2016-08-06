package roboguy99.chemistry_worldgen;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Elements.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry_worldgen.block.OreElement;
import scala.Console;

@Mod(modid = ChemistryWorldGen.modID, version = ChemistryWorldGen.modVersion, name = ChemistryWorldGen.name)
public class ChemistryWorldGen
{
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry_worldgen";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry World Generation";
	
	private List<OreElement> ores = new ArrayList<OreElement>();
	
	public static ChemistryWorldGen instance;
	
	public static List<Element> ORE_LIST;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.instance = this;
		
		new Config();
		
		this.ORE_LIST = new ArrayList<Element>();
		
		this.ORE_LIST.add(EnumElement.ALUMINIUM.getElement());
		this.ORE_LIST.add(EnumElement.SULPHUR.getElement());
		this.ORE_LIST.add(EnumElement.TITANIUM.getElement());
		this.ORE_LIST.add(EnumElement.COPPER.getElement());
		this.ORE_LIST.add(EnumElement.SILVER.getElement());
		this.ORE_LIST.add(EnumElement.TIN.getElement());
		this.ORE_LIST.add(EnumElement.TUNGSTEN.getElement());
		this.ORE_LIST.add(EnumElement.PLATINUM.getElement());
		this.ORE_LIST.add(EnumElement.LEAD.getElement());
		this.ORE_LIST.add(EnumElement.URANIUM.getElement());

		for(Element element : this.ORE_LIST) this.ores.add(new OreElement(element));
		GameRegistry.registerWorldGenerator(new OreGenerator(), 100);
		
		for(OreElement ore : this.ores)
		{	
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ore), 0, new ModelResourceLocation("chemistry_worldgen:" + ore.getName(), "inventory"));
			Chemistry.logger.info(ore.getName());
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{	
		
		generateModels(this.ores);
	}
	
	public static CreativeTabs tabOre = new CreativeTabs("tabOre") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(ChemistryWorldGen.instance.ores.get(0)); //Just get whatever ore is at the top of the list
	    }
	};
	
	public List<OreElement> getOres()
	{
		return this.ores;
	}
	
	/**
	 * Model json generation code
	 * @param ores list of ores to generate for
	 */
	private void generateModels(List<OreElement> ores)
	{
		for(OreElement ore : this.ores)
		{
			String name = ore.getName();
			
			String blockstate = "{ \"variants\": { \"normal\": { \"model\": \"chemistry_worldgen:" + name + "\" } } }";
			String blockModel = "{ \"parent\": \"block/cube_all\", \"textures\": { \"all\": \"chemistry_worldgen:block/" + name + "\"} }";
			String itemModel = "{ \"parent\":\"chemistry_worldgen:block/" + name + "\", \"display\": { \"thirdperson\": { \"rotation\": [ 10, -45, 170 ], \"translation\": [ 0, 1.5, -2.75 ], \"scale\": [ 0.375, 0.375, 0.375 ] } } }";
			
			try 
			{
				Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../out/blockstates/" + name + ".json"), "utf-8"));
				writer.write(blockstate);
				
				writer.close();
				
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../out/models/block/" + name + ".json"), "utf-8"));
				writer.write(blockModel);
				
				writer.close();
				
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../out/models/item/" + name + ".json"), "utf-8"));
				writer.write(itemModel);
				
				writer.close();
			} 
			catch (UnsupportedEncodingException e1) 
			{
				e1.printStackTrace();
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
