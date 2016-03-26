package roboguy99.chemistry.item.compound;

import java.text.AttributedString;
import java.util.LinkedHashMap;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumColour;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class Compound extends Item
{
	private String formula;
	private String name;
	
	public Compound(LinkedHashMap<Element, Integer> structure)
	{	
		this.name = this.getCompoundName(structure);
		this.formula = this.getFormula(structure);
		
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
	this.setCreativeTab(Chemistry.tabElements);
		GameRegistry.registerItem(this, name);
	}
	
	private String getCompoundName(LinkedHashMap<Element, Integer> structure)
	{
		String name = "";
		int elements = 0;
		
		for(Element element : structure.keySet())
		{
			if(elements == 0) name += element.getUnlocalizedName();
			if(elements == 1)
			{
				name += " ";
				name += element.getUnlocalizedName();
				name = name.substring(0, name.length() - 3);
				name += "ide";
			}
			if(elements == 2 && element == Elements.oxygen)
			{
				name = name.substring(0, name.length() - 3);
				name += "ate";
			}
			elements++;
		}
		String commonName = this.getCommonName(name);
		if(commonName != "") return commonName;
		
		return name;
	}
	
	private String getCommonName(String name)
	{
		String commonName = "";
		
		if(name == "Hydrogen Oxide") commonName = "water";
		
		return commonName;
	}
	
	private String getFormula(LinkedHashMap<Element, Integer> structure)
	{
		String formula = "";
		
		for(Element element : structure.keySet())
		{
			formula += element.getSymbol();
			if(structure.get(element) > 1) formula += structure.get(element);
		}
		return subscript(formula);
	}
	
	private String subscript(String str) 
	{
		str = str.replaceAll("0", "\u2080");
		str = str.replaceAll("1", "\u2081");
		str = str.replaceAll("2", "\u2082");
	    str = str.replaceAll("3", "\u2083");
	    str = str.replaceAll("4", "\u2084");
	    str = str.replaceAll("5", "\u2085");
	    str = str.replaceAll("6", "\u2086");
	    str = str.replaceAll("7", "\u2087");
	    str = str.replaceAll("8", "\u2088");
	    str = str.replaceAll("9", "\u2089");
	    return str;
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
			tooltip.add(formula);
		}
	}
}
