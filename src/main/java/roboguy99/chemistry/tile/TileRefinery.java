package roboguy99.chemistry.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import roboguy99.chemistry.api.Constants;
import roboguy99.chemistry.fluid.FilteredFluidTank;
import roboguy99.chemistry.fluid.Fluids;

import javax.annotation.Nullable;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class TileRefinery extends TileMachine implements IFluidHandler
{
	public FilteredFluidTank getInputTank()
	{
		return inputTank;
	}
	
	public FilteredFluidTank getOutputTank()
	{
		return outputTank;
	}
	
	private FilteredFluidTank inputTank;
	private FilteredFluidTank outputTank;
	
	private static final String NAME = "tileRefinery.inventory";
	
	public TileRefinery()
	{
		this.inputTank = new FilteredFluidTank(512000, Fluids.getFluidFromName("oil"));
		inputTank.setTileEntity(this);
		
		this.outputTank = new FilteredFluidTank(512000, Fluids.getFluidFromName("fuel"));
		inputTank.setTileEntity(this);
	}
	
	@Override
	public void update()
	{
		if(!worldObj.isRemote)
		{
			if(this.canProcess())
			{
				if (this.processTimeRemaining > 0) this.processTimeRemaining--;
				this.getEnergyStorage().modifyEnergyStored(-this.getEnergyPerTick());
				
				if(this.processTimeRemaining == 0)
				{
					//this.processTimeRemaining = this.getTickRate();
					this.processTimeRemaining = 1;
					
					/*this.inputTank.setFluidAmount(this.inputTank.getFluidAmount()-1);
					this.outputTank.setFluidAmount(this.outputTank.getFluidAmount()+1);*/
					
					this.inputTank.setFluid(new FluidStack(Fluids.getFluidFromName("oil"), this.inputTank.getFluidAmount()-100));
					this.outputTank.setFluid(new FluidStack(Fluids.getFluidFromName("fuel"), this.outputTank.getFluidAmount()+100));
				}
			}
		}
	}
	
	private boolean canProcess()
	{
		if(this.getEnergyStorage().getEnergyStored() < this.getEnergyPerTick()) return false;
		if(this.inputTank.getFluidAmount() < 100) return false;
		return this.outputTank.getFluidAmount() < this.outputTank.getCapacity();
	}
	
	public int getInputTankScaled(int scale)
	{
		if(this.getInputTank().getFluid() != null)
		{
			float fluid = this.getInputTank().getFluid().amount;
			
			float scaled = (fluid / this.getInputTank().getCapacity()) * scale;
			return (int) scaled;
		}
		return 0;
	}
	
	public int getOutputTankScaled(int scale)
	{
		if(this.getOutputTank().getFluid() != null)
		{
			float fluid = this.getOutputTank().getFluid().amount;
			
			float scaled = (fluid / this.getOutputTank().getCapacity()) * scale;
			return (int) scaled;
		}
		return 0;
	}
	
	@Override
	public int fill(FluidStack resource, boolean doFill)
	{
		return this.inputTank.fill(resource, doFill);
	}
	
	@Nullable
	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain)
	{
		return this.outputTank.drain(resource, doDrain);
	}
	
	@Nullable
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain)
	{
		return this.outputTank.drain(maxDrain, doDrain);
	}
	
	
	@Override
	protected int giveInventorySize()
	{
		return 0;
	}
	
	@Override
	protected String giveName()
	{
		return TileRefinery.NAME;
	}
	
	@Override
	protected int giveTickRate()
	{
		return 1;
	}
	
	@Override
	protected int giveEnergyPerTick()
	{
		return 200;
	}
	
	@Override
	protected int giveMaxEnergy()
	{
		return 50000;
	}
	
	@Override
	protected int giveMaxEnergyIn()
	{
		return 500;
	}
	
	@Override
	public int getField(int id)
	{
		int superField = super.getField(id);
		if(superField != 0) return  superField;
		if(id == Constants.FieldID.INPUT_TANK_STORED) return this.getInputTank().getFluidAmount();
		else if(id == Constants.FieldID.INPUT_TANK_CAPACITY) return this.getInputTank().getCapacity();
		else if(id == Constants.FieldID.OUTPUT_TANK_ONE_STORED) return this.getOutputTank().getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_ONE_CAPACITY) return this.getOutputTank().getCapacity();
		else return 0;
	}
	
	@Override
	public void setField(int id, int value)
	{
		super.setField(id, value);
		if(id == Constants.FieldID.INPUT_TANK_STORED) this.inputTank.setFluid(new FluidStack(Fluids.getFluidFromName("oil"), value));
		if(id == Constants.FieldID.OUTPUT_TANK_ONE_STORED) this.outputTank.setFluid(new FluidStack(Fluids.getFluidFromName("fuel"), value));
	}
	
	@Override
	public int getFieldCount()
	{
		return super.getFieldCount() + 4;
	}
	
	@Override
	public IFluidTankProperties[] getTankProperties()
	{
		return this.inputTank.getTankProperties();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		inputTank.readFromNBT(tag);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		tag = super.writeToNBT(tag);
		inputTank.writeToNBT(tag);
		return tag;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
		{
			if (facing == EnumFacing.UP) return (T) inputTank; //Input only from top TODO Change based on model
			return (T) outputTank;
		}
		return super.getCapability(capability, facing);
	}
}
