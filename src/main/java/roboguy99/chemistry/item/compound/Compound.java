package roboguy99.chemistry.item.compound;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumColour;
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class Compound extends Item
{
	public static Compound instance;
	
	public Compound()
	{
		this.instance = this;
		
		this.setUnlocalizedName("compound");
		this.setMaxStackSize(64);
		this.setCreativeTab(Chemistry.tabElements); //TODO Remove once compound complete
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
		if(CompoundNames.names.containsKey(formula)) name = CompoundNames.names.get(formula);
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
		
		return formula;
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
			tooltip.add(EnumColour.AQUA + "Sneak for more info");
		}
		else
		{
			List<List<Element>> elements = this.convertNBTToList(stack.getTagCompound());
			tooltip.add(EnumColour.YELLOW + this.subscript(this.getFormula(elements)));
			tooltip.add(EnumColour.DARK_AQUA + "Relative mass: " + this.getRelativeMass(elements));
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		if(stack.getTagCompound() == null) return ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
		return StatCollector.translateToLocal(this.getCompoundName(this.convertNBTToList(stack.getTagCompound())));
    }
	
	private List<List<Element>> convertNBTToList(NBTTagCompound tag)
	{	
		List<List<Element>> elements = new ArrayList<List<Element>>();
		
		int quantity = 0;
		for(String position : tag.getKeySet())
		{
			int[] info = tag.getIntArray(position);
			
			Element element = Elements.getElement(info[0]);
			quantity = info[1];
			
			List<Element> currentElement = new ArrayList<Element>();
			for(int i = 0; i < quantity; i++) currentElement.add(element);
			elements.add(currentElement);
		}
		
		return elements;
	}
}
