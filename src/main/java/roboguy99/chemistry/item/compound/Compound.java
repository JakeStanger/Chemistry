package roboguy99.chemistry.item.compound;

import java.text.AttributedString;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumColour;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class Compound extends Item
{
	private String formula;
	private String name;
	private int mass;
	private LinkedHashMap<Element, Integer> structure;
	
	public Compound(LinkedHashMap<Element, Integer> structure)
	{	
		this.name = this.getCompoundName(structure);
		this.formula = this.getFormula(structure);
		this.mass = this.getRelativeMass(structure);
		this.structure = structure;
		
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
	this.setCreativeTab(Chemistry.tabElements);
		GameRegistry.registerItem(this, name);
		//LanguageRegistry.instance().addStringLocalization(this.getUnlocalizedName(), "en_US", name.replaceAll(".name", ""));
	}
	
	public Compound(Compound[] compounds)
	{
		this.name = "";
		this.formula = "";
		this.mass = 0;
		this.structure = new LinkedHashMap<Element, Integer>();
		
		for(Compound compound : compounds)
		{
			this.name += this.getCompoundName(compound.getStructure());
			this.formula += this.getFormula(compound.getStructure());
			this.mass += this.getRelativeMass(compound.getStructure());
			for(Element element : compound.getStructure().keySet())
			{
				if(!this.structure.containsKey(element)) this.structure.put(element, compound.getStructure().get(element));
				else this.structure.put(element, compound.getStructure().get(element) + structure.get(element));
			}
		}
		
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
			if(elements == 0)
			{
				name += StatCollector.translateToLocal(element.getUnlocalizedName() + ".name");
				
				String prefix = "";
				if(structure.get(element) == 2) prefix = "Di";
				if(structure.get(element) == 3) prefix = "Tri";
				
				if(prefix != "") name = name.toLowerCase();
				name = prefix + name;
			}
			if(elements == 1)
			{
				name += " ";
				name += StatCollector.translateToLocal(element.getUnlocalizedName() + ".name");
				name = name.substring(0, name.length() - 3);
				if(name.endsWith("a") || name.endsWith("e") || name.endsWith("i") || name.endsWith("o") || name.endsWith("u") || name.endsWith("y")) //Remove vowels
					name = name.substring(0, name.length() - 1);
				name += "ide";
			}
			if(elements == 2 && element == Elements.oxygen && structure.size() == 3)
			{
				name = name.substring(0, name.length() - 3);
				name += "ate";
			}
			elements++;
		}
		String commonName = this.getCommonName(name);
		if(commonName != "") return commonName;
		
		if(name != "") return name;
		
		return UUID.randomUUID().toString(); //If bork, make ugly. Saves crashing. Probably a bad idea.
	}
	
	private String getCommonName(String name)
	{
		System.out.println(name);
		String commonName = "";
		
		if(name.equals("Dihydrogen Oxide")) commonName = "Water";
		if(name.equals("Carbon Hydrate")) commonName = "Glucose";
		if(name.equals("Oxygen Hydride")) commonName = "Hydroxide";
		
		System.out.println(commonName);
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
	
	private int getRelativeMass(LinkedHashMap<Element, Integer> structure)
	{
		int mass = 0;
		for(Element element : structure.keySet()) mass += (element.getAtomicWeight() * structure.get(element));
		return mass;
	}
	
	public LinkedHashMap<Element, Integer> getStructure()
	{
		return this.structure;
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
			tooltip.add(EnumColour.YELLOW + formula);
			tooltip.add(EnumColour.DARK_AQUA + "Relative mass: " + Integer.toString(mass));
		}
	}
}
