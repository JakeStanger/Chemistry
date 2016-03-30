package roboguy99.chemistry.item.element;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumColour;

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
		this.name = "element." + this.giveName();
		this.symbol = this.giveSymbol();
		
		this.atomicNumber = this.giveAtomicNumber();
		this.atomicMass = this.giveAtomicMass();
		
		this.meltingPoint = this.giveMeltingPoint();
		this.boilingPoint = this.giveBoilingPoint();
		
		this.electronConfiguration = this.giveElectronConfiguration();
		
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
		this.setCreativeTab(Chemistry.tabElements);
		GameRegistry.registerItem(this, name);
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
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		if(!Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode()))
		{
			tooltip.add(EnumColour.AQUA + "Sneak for more info");
		}
		else
		{
			String electronString = "";
			for(int electronShell : electronConfiguration)
			{
				electronString += (electronShell + ".");
			}
			electronString = electronString.substring(0, electronString.length() - 1); //Remove trailing dot
			
			tooltip.add(EnumColour.YELLOW + "Symbol: " + symbol);
			tooltip.add(EnumColour.DARK_AQUA + "Atomic No: " + atomicNumber);
			tooltip.add(EnumColour.DARK_AQUA + "Atomic Mass: " + atomicMass);
			tooltip.add(EnumColour.BRIGHT_PINK + "Electron Configuration: " + electronString);
			tooltip.add(EnumColour.RED + "Melting Point: " + meltingPoint + "\u00B0C");
			tooltip.add(EnumColour.RED + "Boiling Point: " + boilingPoint + "\u00B0C");
			tooltip.add(this.group.groupName);
		}
	}
}
