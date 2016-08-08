package roboguy99.chemistry.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements.Element;
import roboguy99.chemistry.block.ore.BlockOre;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.wrapper.MinMax;

/**
 * @author Roboguy99
 *
 */
public class Ores 
{
	private static HashMap<String, HashMap<ItemElement, MinMax>> oreRegistrants = new HashMap<String, HashMap<ItemElement, MinMax>>();
	private static HashMap<String, ModelResourceLocation> models = new HashMap<String, ModelResourceLocation>();
	
	private static HashMap<BlockOre, String> ores = new HashMap<BlockOre, String>();
	
	public static Ores INSTANCE;
	
	public Ores(FMLPreInitializationEvent event)
	{
		INSTANCE = this;
		getOresFromJSON();
		registerOres();
	}
	
	/**
	 * Reads the ores to add to game from the ores.json file.
	 * Who's Jason and why does he have the ores?
	 */
	private void getOresFromJSON()
	{
		JsonParser parser = new JsonParser();
		try
		{	
			JsonElement element = parser.parse(new FileReader(Chemistry.CONFIG_DIR + "ores.json"));
			JsonArray arr = element.getAsJsonArray();
			
			for(JsonElement ele : arr)
			{
				JsonObject oreData = ele.getAsJsonObject();
				
				String name = oreData.get("name").getAsString();
				String model = oreData.get("model").getAsString();
				
				this.models.put(name, new ModelResourceLocation(model));
				
				JsonObject processObj = oreData.get("processMap").getAsJsonObject();
				HashMap<ItemElement, MinMax> processMap = new HashMap<ItemElement, MinMax>();
				
				for(Entry<String, JsonElement> processData : processObj.entrySet())
				{
					ItemElement itemElement = Elements.getElement(processData.getKey());
					MinMax minMax = new MinMax(processData.getValue().getAsJsonArray().get(0).getAsInt(), processData.getValue().getAsJsonArray().get(1).getAsInt());
					
					processMap.put(itemElement, minMax);
				}
				
				this.oreRegistrants.put(name, processMap);
			}
		}
		catch (JsonIOException | JsonSyntaxException | FileNotFoundException e)
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
	private void addOre(String name, HashMap<ItemElement, MinMax> processContents, ModelResourceLocation model)
	{
		oreRegistrants.put(name, processContents);
		models.put(name, model);
	}
	
	private void registerOres()
	{
		for(String name : oreRegistrants.keySet())
		{
			this.ores.put(new BlockOre(name, models.get(name), oreRegistrants.get(name)), name);
		}
	}
	
	public BlockOre getOre(String name)
	{
		//TODO Write method
		return null;
	}
	
	public HashMap<String, HashMap<ItemElement, MinMax>> getOreRegistrants()
	{
		return this.oreRegistrants;
	}
	
	public HashMap<BlockOre, String> getOres()
	{
		return this.ores;
	}
}
