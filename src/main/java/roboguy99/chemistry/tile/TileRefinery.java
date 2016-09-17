package roboguy99.chemistry.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import roboguy99.chemistry.api.Constants;
import roboguy99.chemistry.block.BlockRefinery;
import roboguy99.chemistry.fluid.FilteredFluidTank;
import roboguy99.chemistry.api.Fluids;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jake stanger
 * Refinery TileEntity.
 * A machine capable of processing oil into various fuels
 */
public class TileRefinery extends TileMachine implements IFluidHandler
{
	private FilteredFluidTank oilTank;
	
	private FilteredFluidTank[] outputTanks = new FilteredFluidTank[6];
	
	private static final String NAME = "tileRefinery.inventory";
	private static final int TANK_SIZE = 10000;
	
	private List<TileRefinery> refineries = new ArrayList<>();
	
	private boolean firstUpdate = true;
	
	public TileRefinery()
	{
		this.oilTank = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName("oil"));
		oilTank.setTileEntity(this);
		
		this.outputTanks[0] = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName(Constants.FuelNames.PETROL));
		this.outputTanks[1] = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName(Constants.FuelNames.NAPHTHA));
		this.outputTanks[2] = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName(Constants.FuelNames.KEROSENE));
		this.outputTanks[3] = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName(Constants.FuelNames.DIESEL));
		this.outputTanks[4] = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName(Constants.FuelNames.LUBRICANT));
		this.outputTanks[5] = new FilteredFluidTank(TANK_SIZE, Fluids.getFluidFromName(Constants.FuelNames.BITUMEN));
		
		for(FilteredFluidTank tank : this.outputTanks)
		{
			tank.setTileEntity(this);
		}
	}
	
	private void updateTowerStatus()
	{
		this.refineries = new ArrayList<>();
		
		TileRefinery hostRefinery;
		if(!this.isBottomRefinery()) hostRefinery = this.getBottomRefinery();
		else hostRefinery = this;
		
		this.refineries.add(hostRefinery);
		
		BlockPos pos = hostRefinery.pos.up();
		while(worldObj.getBlockState(pos).getBlock() instanceof BlockRefinery)
		{
			this.refineries.add((TileRefinery) ((BlockRefinery) worldObj.getBlockState(pos).getBlock()).getTileEntity());
			pos = pos.up();
		}
	}
	
	private boolean isBottomRefinery()
	{
		return !(worldObj.getBlockState(this.pos.down()) instanceof BlockRefinery);
	}
	
	private TileRefinery getBottomRefinery()
	{
		TileRefinery bottomRefinery = this;
		
		BlockPos pos = this.pos.down();
		while(worldObj.getBlockState(pos) instanceof BlockRefinery)
		{
			bottomRefinery = (TileRefinery) ((BlockRefinery) worldObj.getBlockState(pos)).getTileEntity();
		}
		
		return bottomRefinery;
	}
	
	public TileRefinery getHost()
	{
		return this.refineries.get(0);
	}
	
	@Override
	public void update()
	{
		this.updateTowerStatus(); //TODO Fix GUI & mutli-tower code (create some interfaces?)
		//System.out.println(this.refineries);
		
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
					
					/*this.oilTank.setFluidAmount(this.oilTank.getFluidAmount()-1);
					this.outputTank.setFluidAmount(this.outputTank.getFluidAmount()+1);*/
					
					this.oilTank.setFluid(new FluidStack(this.oilTank.getFilter(), this.oilTank.getFluidAmount()-100));
					
					//Add fuel TODO Randomise yields from config
					for(FilteredFluidTank tank : this.outputTanks)
					{
						tank.setFluid(new FluidStack(tank.getFilter(), tank.getFluidAmount()+20));
					}
				}
			}
		}
		
		this.firstUpdate = false;
	}
	
	private boolean canProcess()
	{
		if(this.getEnergyStorage().getEnergyStored() < this.getEnergyPerTick()) return false;
		if(this.oilTank.getFluidAmount() < 100) return false;
		
		for(FilteredFluidTank tank : this.outputTanks) //TODO Base yield on config
		{
			if(tank.getFluidAmount()+20 > tank.getCapacity()) return false;
		}
		
		return true;
	}
	
	public int getInputTankScaled(int scale)
	{
		if(this.getOilTank().getFluid() != null)
		{
			float fluid = this.getOilTank().getFluid().amount;
			
			float scaled = (fluid / this.getOilTank().getCapacity()) * scale;
			return (int) scaled;
		}
		return 0;
	}
	
	public int getOutputTankScaled(int scale, int tankID)
	{
		FilteredFluidTank tank = this.outputTanks[tankID];
		if(tank.getFluid() != null)
		{
			float fluid = tank.getFluid().amount;
			
			float scaled = (fluid / tank.getCapacity()) * scale;
			return (int) scaled;
		}
		return 0;
	}
	
	@Override
	public int fill(FluidStack resource, boolean doFill)
	{
		return this.oilTank.fill(resource, doFill);
	}
	
	@Nullable
	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain)
	{
		return this.oilTank.drain(resource, doDrain);
	}
	
	@Nullable
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain)
	{
		return this.oilTank.drain(maxDrain, doDrain);
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
	public int getField(int id) //TODO Tidy (and setField)
	{
		int superField = super.getField(id);
		if(superField != 0) return  superField;
		
		if(id == Constants.FieldID.INPUT_TANK_STORED) return this.getOilTank().getFluidAmount();
		else if(id == Constants.FieldID.INPUT_TANK_CAPACITY) return this.getOilTank().getCapacity();
		
		else if(id == Constants.FieldID.OUTPUT_TANK_ONE_STORED) return this.outputTanks[0].getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_ONE_CAPACITY) return this.outputTanks[0].getCapacity();
		
		else if(id == Constants.FieldID.OUTPUT_TANK_TWO_STORED) return this.outputTanks[1].getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_TWO_CAPACITY) return this.outputTanks[1].getCapacity();
		
		else if(id == Constants.FieldID.OUTPUT_TANK_THREE_STORED) return this.outputTanks[2].getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_THREE_CAPACITY) return this.outputTanks[2].getCapacity();
		
		else if(id == Constants.FieldID.OUTPUT_TANK_FOUR_STORED) return this.outputTanks[3].getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_FOUR_CAPACITY) return this.outputTanks[3].getCapacity();
		
		else if(id == Constants.FieldID.OUTPUT_TANK_FIVE_STORED) return this.outputTanks[4].getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_FIVE_CAPACITY) return this.outputTanks[4].getCapacity();
		
		else if(id == Constants.FieldID.OUTPUT_TANK_SIX_STORED) return this.outputTanks[5].getFluidAmount();
		else if(id == Constants.FieldID.OUTPUT_TANK_SIX_CAPACITY) return this.outputTanks[5].getCapacity();
		
		else return 0;
	}
	
	@Override
	public void setField(int id, int value)
	{
		super.setField(id, value);
		if(id == Constants.FieldID.INPUT_TANK_STORED) this.oilTank.setFluid(new FluidStack(Fluids.getFluidFromName("oil"), value));
		
		if(id == Constants.FieldID.OUTPUT_TANK_ONE_STORED) this.outputTanks[0].setFluid(new FluidStack(Fluids.getFluidFromName(Constants.FuelNames.PETROL), value));
		if(id == Constants.FieldID.OUTPUT_TANK_TWO_STORED) this.outputTanks[1].setFluid(new FluidStack(Fluids.getFluidFromName(Constants.FuelNames.NAPHTHA), value));
		if(id == Constants.FieldID.OUTPUT_TANK_THREE_STORED) this.outputTanks[2].setFluid(new FluidStack(Fluids.getFluidFromName(Constants.FuelNames.KEROSENE), value));
		if(id == Constants.FieldID.OUTPUT_TANK_FOUR_STORED) this.outputTanks[3].setFluid(new FluidStack(Fluids.getFluidFromName(Constants.FuelNames.DIESEL), value));
		if(id == Constants.FieldID.OUTPUT_TANK_FIVE_STORED) this.outputTanks[4].setFluid(new FluidStack(Fluids.getFluidFromName(Constants.FuelNames.LUBRICANT), value));
		if(id == Constants.FieldID.OUTPUT_TANK_SIX_STORED) this.outputTanks[5].setFluid(new FluidStack(Fluids.getFluidFromName(Constants.FuelNames.NAPHTHA), value));
	}
	
	@Override
	public int getFieldCount() //TODO Remove magic number
	{
		return super.getFieldCount() + 14;
	}
	
	@Override
	public IFluidTankProperties[] getTankProperties()
	{
		return this.oilTank.getTankProperties();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		oilTank.readFromNBT(tag);
		
		for(FilteredFluidTank tank : this.outputTanks)
		{
			tank.readFromNBT(tag);
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		tag = super.writeToNBT(tag);
		oilTank.writeToNBT(tag);
		
		for(FilteredFluidTank tank : this.outputTanks)
		{
			tank.writeToNBT(tag);
		}
		
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
			if (this.refineries.size() > 1 && this.refineries.get(0) != null && this.refineries.get(0) == this) return (T) oilTank; //TODO Change based on model
			for(int i = 1; i < this.refineries.size(); i++)
			{
				if (this.refineries.get(i) != null && this.refineries.get(i) == this) return (T) this.outputTanks[i - 1];
			}
		}
		
		
		return super.getCapability(capability, facing);
	}
	
	public FilteredFluidTank getOilTank()
	{
		return this.oilTank;
	}
	
	public FilteredFluidTank[] getOutputTanks()
	{
		return this.outputTanks;
	}
}
