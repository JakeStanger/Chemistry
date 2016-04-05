package roboguy99.chemistry.item.compound;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Colour;
import roboguy99.chemistry.api.CompoundNames;
import roboguy99.chemistry.item.element.Element;

public class Compound extends Item
{
	public static Compound instance;
	
	public Compound()
	{
		this.instance = this;
		
		this.setUnlocalizedName("compound");
		this.setMaxStackSize(64);
		GameRegistry.registerItem(this, "compound");
	}
	
	/**
	 * Returns the common name for the given list of elements, or the formula if there isn't one
	 * @param elements A 2D list of elements
	 * @return The compound name
	 */
	private String getCompoundName(List<List<Element>> elements)
	{
		String formula = this.getFormula(elements);
		
		String name = "";
		if(CompoundNames.isFormulaInMap(formula)) name = CompoundNames.getName(formula);
		else name = this.subscript(formula);
		
		return name;
	}
	
	private String getFormula(List<List<Element>> elements)
	{
		String formula = "";
		
		for(List<Element> currentElement : elements)
		{
			formula += currentElement.get(0).getSymbol(); //Every element is identical, so looking at 0 will always be safe
			if(currentElement.size() > 1) formula += currentElement.size();
		}
		
		return this.factorise(formula);
	}
	
	
	/**
	 * Gets any consecutive repeated molecules, separated by a |, and returns the factorised version
	 * @author robotlos (http://stackoverflow.com/users/5976941/robotlos)
	 * @param input a fully expanded chemical formula
	 * @return a factorised chemical formula
	 */
	private String factorise(String input) 
	{ 
		String result = ""; 
		Map<String, Integer> molecules = new LinkedHashMap<String, Integer>(); 
		String[] res = input.split("\\|"); 
		for (String t : res) 
		{ 
			if (!molecules.containsKey(t)) molecules.put(t, 1); //If we don't already have this element in the map, then add it and set the count to 1 
			else molecules.put(t, molecules.get(t) + 1); 
		} 
		//Iterate through each molecule 
		for (String key : molecules.keySet()) 
		{ 
			if (molecules.get(key) == 1) result += key; //If the count is only at one, then we just need to append it. 
			else result = result + "(" + key + ")" + molecules.get(key); //Otherwise, we need the parentheses and the number of repetitions followed after 
		} 
		return result; 
	}
	
	private int getRelativeMass(List<List<Element>> elements)
	{
		int mass = 0;
		for(List<Element> element : elements) mass += (element.get(0).getAtomicMass() * element.size());
		return mass;
	}
	
	/**
	 * Replace any numbers in a string with subscript
	 * @param string
	 * @return string with subscript
	 */
	private String subscript(String string) 
	{
		string = string.replaceAll("0", "\u2080");
		string = string.replaceAll("1", "\u2081");
		string = string.replaceAll("2", "\u2082");
	    string = string.replaceAll("3", "\u2083");
	    string = string.replaceAll("4", "\u2084");
	    string = string.replaceAll("5", "\u2085");
	    string = string.replaceAll("6", "\u2086");
	    string = string.replaceAll("7", "\u2087");
	    string = string.replaceAll("8", "\u2088");
	    string = string.replaceAll("9", "\u2089");
	    
	    return string;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		if(!Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode()))
		{
			tooltip.add(Colour.DARK_GREEN + "Sneak for more info");
		}
		else
		{
			try
			{
				List<List<Element>> elements = this.convertNBTToList(stack.getTagCompound());
				tooltip.add(Colour.YELLOW + this.subscript(this.getFormula(elements)));
				tooltip.add(Colour.DARK_AQUA + "Relative mass: " + this.getRelativeMass(elements));
			}
			catch(Exception e)
			{
				tooltip.add(Colour.RED + "Well something broke...");
			}
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		try
		{
			return StatCollector.translateToLocal(this.getCompoundName(this.convertNBTToList(stack.getTagCompound())));
		}
			
		catch(Exception e)
		{
			return ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
		}
    }
	
	private List<List<Element>> convertNBTToList(NBTTagCompound tag)
	{			
		List<List<Element>> elements = new ArrayList<List<Element>>();
		
		int quantity = 0;
		
		for(int i = 0; i < tag.getKeySet().size(); i++)
		{
			int[] info = tag.getIntArray(Integer.toString(i));
			
			Element element = Elements.getElement(info[0]);
			quantity = info[1];
			
			List<Element> currentElement = new ArrayList<Element>();
			for(int j = 0; j < quantity; j++) currentElement.add(element);
			elements.add(currentElement);
		}
		return elements;
	}
}
