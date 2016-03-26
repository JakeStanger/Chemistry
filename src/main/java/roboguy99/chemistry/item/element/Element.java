package roboguy99.chemistry.item.element;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;

public abstract class Element extends Item
{
	private String name;
	private String symbol;
	
	private int atomicNumber;
	private int atomicMass;
	
	private int meltingPoint;
	private int boilingPoint;
	
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
	
	public String getSymbol()
	{
		return this.symbol;
	}
	
	public int getAtomicNumber()
	{
		return this.atomicNumber;
	}
	
	public int getAtomicWeight()
	{
		return this.atomicMass;
	}
	
	public int getMeltingPoint()
	{
		return this.meltingPoint;
	}
	
	public int getBoilingPoint()
	{
		return this.boilingPoint;
	}
	
	public abstract String giveName();
	public abstract String giveSymbol();
	public abstract int giveAtomicNumber();
	public abstract int giveAtomicMass();
	public abstract int giveMeltingPoint();
	public abstract int giveBoilingPoint();
	public abstract int[] giveElectronConfiguration();

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		String electronString = "";
		for(int electronShell : electronConfiguration)
		{
			electronString += (electronShell + ".");
		}
		electronString = electronString.substring(0, electronString.length() - 1); //Remove trailing dot
		
		tooltip.add("Symbol: " + symbol);
		tooltip.add("Atomic No: " + atomicNumber);
		tooltip.add("Atomic Mass: " + atomicMass);
		tooltip.add("Electron Configuration: " + electronString);
		tooltip.add("Melting Point: " + meltingPoint);
		tooltip.add("Boiling Point: " + boilingPoint);
	}
}
