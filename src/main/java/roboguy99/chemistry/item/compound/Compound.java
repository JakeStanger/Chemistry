package roboguy99.chemistry.item.compound;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumColour;
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class Compound extends Item
{
	private String formula;
	private String name;
	private int mass;
	private LinkedHashMap<Element, Integer> structure;
	
	public Compound()
	{
		this.setUnlocalizedName("compound");
		this.setMaxStackSize(64);
		this.setCreativeTab(Chemistry.tabElements);
		GameRegistry.registerItem(this, "compound");
	}
	
	public Compound(LinkedHashMap<Element, Integer> structure)
	{	
		this.name = this.getCompoundName(structure);
		this.formula = this.getFormula(structure);
		this.mass = this.getRelativeMass(structure);
		this.structure = structure;
		
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
	this.setCreativeTab(Chemistry.tabElements);
		try
		{
			GameRegistry.registerItem(this, name);
		}
		catch(Exception e)
		{
			GameRegistry.registerItem(this, name + UUID.randomUUID().toString().substring(0, 4));
		}
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
			}
			if(elements == 1)
			{
				name += " ";
				name += StatCollector.translateToLocal(element.getUnlocalizedName() + ".name");
				name = name.substring(0, name.length() - 3);
				
				String[] vowels = {"a", "e", "i", "o", "u", "y"};
				for(String vowel: vowels) if(name.endsWith(vowel)) name = name.substring(0, name.length() - 1);
				name += "ide";
			}
			if(elements == 2 && element == Elements.getElement(EnumElement.OXYGEN) && structure.size() == 3)
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
		System.out.println(name);
		String commonName = "";
		
		if(name.equals("Hydrogen Oxide")) commonName = "Water";
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
	
	public void setNBTData(ItemStack itemStack)
	{
		NBTTagCompound compound = itemStack.getTagCompound();
		compound.setString("name", name);
		compound.setString("formula", formula);
		compound.setInteger("mass", mass);
		
		NBTTagCompound structure = new NBTTagCompound();
		
		for(Element element : this.structure.keySet())
		{
			structure.setInteger(element.getItemStackDisplayName(new ItemStack(element)), this.structure.get(element));
		}
		
		compound.setTag("Structure", structure);
	}
	
	public void getNBTData(ItemStack itemStack)
	{
		NBTTagCompound compound = itemStack.getTagCompound();
		
		this.name = compound.getString("name");
		this.formula = compound.getString("formula");
		this.mass = compound.getInteger("mass");
		
		NBTTagCompound structureNBT = compound.getCompoundTag("Structure");
		LinkedHashMap<Element, Integer> structure = new LinkedHashMap<Element, Integer>();
		
		for(String elementName : structureNBT.getKeySet())
		{
			//Do something
		}
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(stack.getTagCompound() == null)
		{
			stack.setTagCompound(new NBTTagCompound());
			this.setNBTData(stack);
		}
    }
}
