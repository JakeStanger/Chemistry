package roboguy99.chemistry.tile;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import roboguy99.chemistry.api.FieldID;

/**
 * @author Jake stanger
 * A TileEntity with an inventory, energy buffer and tick.
 */
public abstract class TileMachine extends TileInventory implements ITickable, IEnergyReceiver
{
	private int tickRate;
	private int energyPerTick;
	private int maxEnergy;
	
	private int maxEnergyIn = 500;
	
	protected int processTimeRemaining = tickRate;
	
	private EnergyStorage energyStorage;
	
	public TileMachine()
	{
		this.tickRate = this.giveTickRate();
		this.energyPerTick = this.giveEnergyPerTick();
		this.maxEnergy = this.giveMaxEnergy();
		this.maxEnergyIn = this.giveMaxEnergyIn();
		
		this.energyStorage = new EnergyStorage(this.maxEnergy, this.maxEnergyIn);
	}
	
	protected abstract int giveTickRate();
	protected abstract int giveEnergyPerTick();
	protected abstract int giveMaxEnergy();
	protected abstract int giveMaxEnergyIn();
	
	@Override
	public boolean canConnectEnergy(EnumFacing from)
	{
		return true;
	}
	
	@Override
	public int getEnergyStored(EnumFacing from)
	{
		return this.energyStorage.getEnergyStored();
	}
	
	@Override
	public int getMaxEnergyStored(EnumFacing from)
	{
		return this.energyStorage.getMaxEnergyStored();
	}
	
	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate)
	{
		return this.energyStorage.receiveEnergy(maxReceive, simulate);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.energyStorage.readFromNBT(nbt);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		this.energyStorage.writeToNBT(nbt);
		
		return nbt;
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound nbtTag = new NBTTagCompound();
		nbtTag.setInteger("Energy", this.energyStorage.getEnergyStored());
		this.energyStorage.setEnergyStored(nbtTag.getInteger("Energy"));
		writeEnergy(nbtTag);
		writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(this.pos, 0, nbtTag);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
	{
		readEnergy(packet.getNbtCompound());
		readFromNBT(packet.getNbtCompound());
	}
	
	public void readEnergy(NBTTagCompound nbt)
	{
		if (nbt.hasKey("storage")) this.energyStorage.readFromNBT(nbt.getCompoundTag("storage"));
	}
	
	public void writeEnergy(NBTTagCompound nbt)
	{
		NBTTagCompound energyTag = new NBTTagCompound();
		this.energyStorage.writeToNBT(energyTag);
		nbt.setTag("storage", energyTag);
	}
	
	public int getTickRate()
	{
		return tickRate;
	}
	
	public int getEnergyPerTick()
	{
		return energyPerTick;
	}
	
	public int getMaxEnergy()
	{
		return maxEnergy;
	}
	
	public int getMaxEnergyIn()
	{
		return maxEnergyIn;
	}
	
	public EnergyStorage getEnergyStorage()
	{
		return energyStorage;
	}
	
	@Override
	public int getField(int id)
	{
		if(id == FieldID.PROCESS_TIME_REMAINING.fieldID) return this.processTimeRemaining;
		else if(id == FieldID.TICK_RATE.fieldID) return this.tickRate;
		else if (id == FieldID.ENERGY_STORED.fieldID) return this.energyStorage.getEnergyStored();
		else if (id == FieldID.TOTAL_ENERGY.fieldID) return this.energyStorage.getMaxEnergyStored();
		else return 0;
	}
	
	@Override
	public void setField(int id, int value)
	{
		if (id == FieldID.PROCESS_TIME_REMAINING.fieldID) this.processTimeRemaining = value;
		if (id == FieldID.ENERGY_STORED.fieldID) this.getEnergyStorage().setEnergyStored(value);
	}
	
	@Override
	public int getFieldCount()
	{
		return 4;
	}
}
