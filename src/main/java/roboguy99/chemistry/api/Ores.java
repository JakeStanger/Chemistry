package roboguy99.chemistry.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import roboguy99.chemistry.api.Elements.Element;
import roboguy99.chemistry.block.ore.BlockOre;
import roboguy99.chemistry.wrapper.MinMax;

/**
 * @author Roboguy99
 *
 */
public class Ores 
{
	private static HashMap<String, HashMap<Element, MinMax>> oreRegistrants = new HashMap<String, HashMap<Element, MinMax>>();
	private static HashMap<String, ModelResourceLocation> models = new HashMap<String, ModelResourceLocation>();
	
	private static List<BlockOre> ores = new ArrayList<BlockOre>();
	
	public static Ores INSTANCE;
	
	public Ores(FMLPreInitializationEvent event) //TODO Give ore registry code a new home
	{
		INSTANCE = this;
		
		HashMap<Element, MinMax> bauxiteMap = new HashMap<Element, MinMax>();
		bauxiteMap.put(Element.ALUMINIUM, new MinMax(3, 6));
		
		HashMap<Element, MinMax> copperMap = new HashMap<Element, MinMax>();
		copperMap.put(Element.COPPER, new MinMax(3, 6));
		
		HashMap<Element, MinMax> leadMap = new HashMap<Element, MinMax>();
		leadMap.put(Element.LEAD, new MinMax(3, 6));
		
		HashMap<Element, MinMax> platinumMap = new HashMap<Element, MinMax>();
		platinumMap.put(Element.PLATINUM, new MinMax(3, 6));
		
		HashMap<Element, MinMax> silverMap = new HashMap<Element, MinMax>();
		silverMap.put(Element.SILVER, new MinMax(3, 6));
		
		HashMap<Element, MinMax> sulphurMap = new HashMap<Element, MinMax>();
		sulphurMap.put(Element.SULPHUR, new MinMax(3, 6));
		
		HashMap<Element, MinMax> tinMap = new HashMap<Element, MinMax>();
		tinMap.put(Element.TIN, new MinMax(3, 6));
		
		HashMap<Element, MinMax> titaniumMap = new HashMap<Element, MinMax>();
		titaniumMap.put(Element.TITANIUM, new MinMax(3, 6));
		
		HashMap<Element, MinMax> tungstenMap = new HashMap<Element, MinMax>();
		tungstenMap.put(Element.TUNGSTEN, new MinMax(3, 6));
		
		HashMap<Element, MinMax> uraniumMap = new HashMap<Element, MinMax>();
		uraniumMap.put(Element.URANIUM, new MinMax(3, 6));
		
		try
		{
			this.addOre("bauxite", bauxiteMap, new ModelResourceLocation("chemistry:ore_bauxite"), event);
			this.addOre("copper", copperMap, new ModelResourceLocation("chemistry:ore_copper"), event);
		}
		catch (OreWithNameExistsException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Add an ore to the ores list, ready to be registered.
	 * Must be called in pre-init otherwise it will be ignored.
	 * 
	 * @param name The unlocalised name of the ore. There is no need to include "ore" in the name as this is automatically appended.
	 * @param processContents The minimum and maximum. 
	 * @param model The model to associate to the ore.
	 * @param event The pre-init event as a fail-safe.
	 * @throws OreWithNameExistsException If an ore is added to the registry with a duplicate key
	 */
	public void addOre(String name, HashMap<Element, MinMax> processContents, ModelResourceLocation model, FMLPreInitializationEvent event) throws OreWithNameExistsException
	{
		if(!oreRegistrants.containsKey(name))
		{
			oreRegistrants.put(name, processContents);
			models.put(name, model);
		}
		else throw new OreWithNameExistsException();
	}
	
	public void registerOres(FMLInitializationEvent event)
	{
		for(String name : oreRegistrants.keySet())
		{
			this.ores.add(new BlockOre(name, models.get(name)));
		}
	}
	
	public BlockOre getOre(String name)
	{
		//TODO Write method
		return null;
	}
	
	public HashMap<String, HashMap<Element, MinMax>> getOreRegistrants()
	{
		return this.oreRegistrants;
	}
	
	public List<BlockOre> getOres()
	{
		return this.ores;
	}
	
	public class OreWithNameExistsException extends Exception
	{
		public OreWithNameExistsException()
		{
			super("An ore with that name is already in the registry");
		}
	}
}
