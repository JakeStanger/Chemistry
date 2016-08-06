package roboguy99.chemistry.item.element;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Colour;
import roboguy99.chemistry.api.Group;

/**
 * The item class for a chemical element.
 * Extend this to create an element.
 * @author Roboguy99
 *
 */
public abstract class Element extends Item
{
	/**
	 * The unlocalised name of the element
	 */
	private String name;
	/**
	 * The chemical symbol for the element
	 */
	private String symbol;
	/**
	 * The chemical group for the element
	 */
	private Group group;
	
	/**
	 * The atomic number of the element
	 */
	private int atomicNumber;
	/**
	 * The relative atomic mass of the element
	 */
	private int atomicMass;
	
	/**
	 * The melting point of the element in Celsius
	 */
	private int meltingPoint;
	/**
	 * The boiling point of the element in Celsius
	 */
	private int boilingPoint;
	
	/**
	 * Technically the name is slightly incorrect.
	 * The number of electrons per shell for the atom
	 */
	private int[] electronConfiguration;
	
	public Element()
	{	
		this.name = "element_" + this.giveName();
		this.symbol = this.giveSymbol();
		this.group = this.giveGroup();
		
		this.atomicNumber = this.giveAtomicNumber();
		this.atomicMass = this.giveAtomicMass();
		
		this.meltingPoint = this.giveMeltingPoint();
		this.boilingPoint = this.giveBoilingPoint();
		
		this.electronConfiguration = this.giveElectronConfiguration();
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setMaxStackSize(64);
		this.addToCreativeTab();
		GameRegistry.register(this);
	}
	
	/**
	 * Add the element to the elements creative tab.
	 * If you do not call this, the element will not be accessible in creative mode.
	 */
	protected void addToCreativeTab()
	{
		this.setCreativeTab(Chemistry.tabElements);
	}
	
	/**
	 * @return the unlocalised name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * @return the chemical symbol
	 */
	public String getSymbol()
	{
		return this.symbol;
	}
	
	public Group getGroup()
	{
		return this.group;
	}
	
	/**
	 * @return the atomic number
	 */
	public int getAtomicNumber()
	{
		return this.atomicNumber;
	}
	
	/**
	 * @return the relative atomic mass
	 */
	public int getAtomicMass()
	{
		return this.atomicMass;
	}
	
	/**
	 * @return the melting point, in Celsius
	 */
	public int getMeltingPoint()
	{
		return this.meltingPoint;
	}
	
	/**
	 * @return the boiling point, in Celsius
	 */
	public int getBoilingPoint()
	{
		return this.boilingPoint;
	}
	
	public abstract String giveName();
	public abstract String giveSymbol();
	public abstract Group giveGroup();
	public abstract int giveAtomicNumber();
	public abstract int giveAtomicMass();
	public abstract int giveMeltingPoint();
	public abstract int giveBoilingPoint();
	public abstract int[] giveElectronConfiguration();

	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return this.getGroupColour() + ("" + I18n.format(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
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
			String electronString = "";
			for(int electronShell : electronConfiguration)
			{
				electronString += (electronShell + ".");
			}
			electronString = electronString.substring(0, electronString.length() - 1); //Remove trailing dot
			
			tooltip.add(Colour.DARK_AQUA + "Atomic No: " + atomicNumber);
			tooltip.add(Colour.DARK_AQUA + "Atomic Mass: " + atomicMass);
			tooltip.add(Colour.BRIGHT_PINK + "Electron Configuration: " + electronString);
			if(meltingPoint != Integer.MAX_VALUE) tooltip.add(Colour.RED + "Melting Point: " + meltingPoint + "\u00B0C"); 
			else tooltip.add(Colour.RED + "Melting Point: Unknown");
			if(boilingPoint != Integer.MAX_VALUE) tooltip.add(Colour.RED + "Boiling Point: " + boilingPoint + "\u00B0C");
			else tooltip.add(Colour.RED + "Boiling Point: Unknown");
			tooltip.add(this.getGroupColour() + I18n.format(this.group.groupName));
		}
	}
	
	private Colour getGroupColour()
	{
		Colour groupColour;
		
		switch(this.group)
		{
			case ALKALI_METALS:
				groupColour = Colour.WHITE;
				break;
			case ALKALINE_EARTH_METALS:
				groupColour = Colour.PINK;
				break;
			case TRANSITION_METALS:
				groupColour = Colour.AQUA;
				break;
			case OTHER_METALS:
				groupColour = Colour.ORANGE;
				break;
			case NON_METALS:
				groupColour = Colour.BRIGHT_GREEN;
				break;
			case NOBLE_GASES:
				groupColour = Colour.YELLOW;
				break;
			default:
				groupColour = Colour.WHITE;
				break;
		}
		
		return groupColour;
	}
}
