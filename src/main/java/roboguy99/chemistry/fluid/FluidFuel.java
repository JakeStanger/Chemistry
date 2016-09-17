package roboguy99.chemistry.fluid;

import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.wrapper.MinMax;

import java.util.HashMap;

/**
 * @author Jake stanger
 * TODO Integrate into base fluid
 */
public class FluidFuel extends FluidBasic
{
	private HashMap<Compound, MinMax> resourceMap;
	private boolean isGas;
	private int meltingPoint, boilingPoint;
	
	public FluidFuel(String name) //TODO Remove constructor and add real fluid values
	{
		super(name);
	}
	
	public FluidFuel(String name, boolean isGas, int meltingPoint, int boilingPoint, HashMap<Compound, MinMax> resourceMap)
	{
		super(name);
		this.resourceMap = resourceMap;
	}
	
	public FluidFuel(String name, int density, int viscosity, int meltingPoint, int boilingPoint, HashMap<Compound, MinMax> resourceMap)
	{
		super(name, density, viscosity);
		this.resourceMap = resourceMap;
	}
	
	
}
