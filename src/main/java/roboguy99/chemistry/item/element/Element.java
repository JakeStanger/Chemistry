package roboguy99.chemistry.item.element;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;

public class Element extends Item
{
	private String symbol;
	
	private int atomicNumber;
	private int atomicMass;
	
	private int meltingPoint;
	private int boilingPoint;
	
	private int[] electronConfiguration;
	
	public Element(String name, String symbol, int atomicNumber, int atomicMass, int meltingPoint, int boilingPoint, int[] electronConfiguration)
	{
		this.setCreativeTab(Chemistry.tabElements);
		
		this.symbol = symbol;
		
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		
		this.meltingPoint = meltingPoint;
		this.boilingPoint = boilingPoint;
		
		this.electronConfiguration = electronConfiguration;
		
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
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
	
	public abstract void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public abstract void setAtomicMass(int atomicMass) {
		this.atomicMass = atomicMass;
	}

	public abstract void setMeltingPoint(int meltingPoint) {
		this.meltingPoint = meltingPoint;
	}

	public abstract void setBoilingPoint(int boilingPoint) {
		this.boilingPoint = boilingPoint;
	}

	public abstract void setElectronConfiguration(int[] electronConfiguration) {
		this.electronConfiguration = electronConfiguration;
	}

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
