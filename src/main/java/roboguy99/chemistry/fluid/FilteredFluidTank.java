package roboguy99.chemistry.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import javax.annotation.Nullable;

/**
 * @author Jake stanger
 * A FluidTank for which a fluid can be specified.
 * The specified fluid is the only fluid which is allowed into the tank.
 */
public class FilteredFluidTank extends FluidTank
{
	public Fluid getFilter()
	{
		return filter;
	}
	
	private Fluid filter;
	
	public FilteredFluidTank(int capacity, Fluid filter)
	{
		super(capacity);
		this.filter = filter;
	}
	
	public FilteredFluidTank(@Nullable FluidStack fluidStack, int capacity, Fluid filter)
	{
		super(fluidStack, capacity);
		this.filter = filter;
	}
	
	public FilteredFluidTank(Fluid fluid, int amount, int capacity, Fluid filter)
	{
		super(fluid, amount, capacity);
		this.filter = filter;
	}
	
	@Override
	public boolean canFillFluidType(FluidStack fluid)
	{
		return fluid.getFluid() == this.filter && super.canFillFluidType(fluid);
	}
	
	public void setFluidAmount(int amount)
	{
		if (this.fluid != null)
		{
			this.fluid.amount = amount;
		}
	}
}
