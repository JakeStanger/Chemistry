package roboguy99.chemistry.tile;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import roboguy99.chemistry.block.BlockOre;
import roboguy99.chemistry.item.block.ItemBlockOre;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.wrapper.MinMax;

import java.util.HashMap;
import java.util.Random;

public class TileOreProcessor extends TileMachine
{
	private static final int SIZE = 19;
	private static final String NAME = "tileCompoundCreator.inventory";
	
	private static final int TICK_RATE = 100; //TODO Set process time
	
	private static final int ENERGY_PER_TICK = 100;
	private static final int MAX_ENERGY = 10000;
	private static final int MAX_ENERGY_IN = 500;
	
	private HashMap<ItemElement, MinMax> elements;
	private int currentElementQuantity;
	
	@Override
	protected int giveTickRate()
	{
		return TileOreProcessor.TICK_RATE;
	}
	
	@Override
	protected int giveEnergyPerTick()
	{
		return TileOreProcessor.ENERGY_PER_TICK;
	}
	
	@Override
	protected int giveMaxEnergy()
	{
		return TileOreProcessor.MAX_ENERGY;
	}
	
	@Override
	protected int giveMaxEnergyIn()
	{
		return TileOreProcessor.MAX_ENERGY_IN;
	}
	
	@Override
	protected int giveInventorySize()
	{
		return TileOreProcessor.SIZE;
	}
	
	@Override
	protected String giveName()
	{
		return TileOreProcessor.NAME;
	}
	
	/**
	 * Runs every tick.
	 * Handles processing of input items into output items.
	 */
	@Override
	public void update()
	{
		ItemStack stackIn = this.getStackInSlot(TileMachine.INPUT_SLOT);
		
		if(stackIn != null && !worldObj.isRemote)
		{
			if(this.elements == null) this.elements = this.assignRandomElements(stackIn.getItem());
			
			//Check there is room to place stack first. Not definite based on random generation system.
			//Other checks are in place.
			if(this.canProcess())
			{
				if(this.processTimeRemaining > 0) this.processTimeRemaining--;
				this.getEnergyStorage().modifyEnergyStored(-this.getEnergyPerTick());
				
				if(this.processTimeRemaining == 0)
				{
					this.processTimeRemaining = TileOreProcessor.TICK_RATE;
					
					for(ItemElement element : this.elements.keySet())
					{
						Random random = new Random();
						
						//Create ItemStack to place.
						MinMax minMax = this.elements.get(element);
						this.currentElementQuantity = random.nextInt(minMax.getMax() +1 - minMax.getMin()) + minMax.getMin();
						ItemStack elementStack = new ItemStack(element, this.currentElementQuantity);
						
						while(elementStack.stackSize > 0) //Repeat until whole stack is placed.
						{
							//Attempt to place in non-null slot first
							int slot = this.getFirstSlotWithRoom(element);
							
							if (slot != -1)
							{
								elementStack = this.addStackToSlot(elementStack, slot);
							}
							else //If all non-null slots are full
							{
								slot = this.getFirstEmptySlot();
								if(slot != -1)
								{
									this.setInventorySlotContents(slot, ItemStack.copyItemStack(elementStack));
									elementStack.stackSize = 0;
								}
							}
						}
					}
					//Once all elements are placed, reduce input & energy
					//this.getEnergyStorage().modifyEnergyStored(-TileOreProcessor.ENERGY_PER_TICK);
					
					stackIn.stackSize--;
					if(stackIn.stackSize == 0) //Delete stack & reset info if input empty
					{
						this.setInventorySlotContents(TileOreProcessor.INPUT_SLOT, null);
						this.elements = null; //Reset element map when input empty.
						this.processTimeRemaining = TileOreProcessor.TICK_RATE;
					}
					this.markDirty();
				}
			}
			else this.processTimeRemaining = TileOreProcessor.TICK_RATE;
		}
		else
		{
			this.elements = null;
		}
	}
	
	/**
	 * Assigns random elements based on the item given, assuming the item is an ore.
	 * The quantity of elements is based on the ore's resource map.
	 * @param item The item to assign elements to.
	 * @return A map of assigned elements and quantities.
	 */
	private HashMap<ItemElement, MinMax> assignRandomElements(Item item)
	{
		HashMap<ItemElement, MinMax> elements = new HashMap<>();
		
		if(item instanceof ItemBlockOre) //Check item is ore
		{
			BlockOre ore = ((ItemBlockOre) item).getOre();
			
			for(ItemElement element : ore.getResourceMap().keySet())
			{
				MinMax minMax = ore.getResourceMap().get(element);
				elements.put(element, minMax);
			}
		}
		
		return elements;
	}
	
	/**
	 * Checks if the machine has enough output capacity
	 * and power to process its input.
	 * This method is not definite due to the random generation system.
	 * @return True if the machine can process.
	 */
	private boolean canProcess()
	{
		if(this.getEnergyStorage().getEnergyStored() < TileOreProcessor.ENERGY_PER_TICK) return false;
		
		if(this.getNumOfEmptySlots() >= this.elements.keySet().size()) return true;
		
		boolean enoughRoom = true;
		for(ItemElement element : this.elements.keySet())
		{
			if(this.getFirstSlotWithRoom(element, TileOreProcessor.OUTPUT_SLOTS_BEGIN, this.currentElementQuantity) == -1) enoughRoom = false;
		}
		
		return enoughRoom;
	}
	
	
	@SuppressWarnings({"ConstantConditions", "NullableProblems"})
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("progress", this.processTimeRemaining);
		
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		if(nbt.hasKey("progress")) this.processTimeRemaining = nbt.getInteger("progress");
	}
}
