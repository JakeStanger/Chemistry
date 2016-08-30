package roboguy99.chemistry.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import roboguy99.chemistry.block.ore.BlockOre;
import roboguy99.chemistry.item.block.ItemBlockOre;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.wrapper.MinMax;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Random;

public class TileOreProcessor extends TileEntity implements IInventory, ITickable
{
	private static final int SIZE = 19;
	private static final String NAME = "tileCompoundCreator.inventory";
	
	private ItemStack[] inventory;
	private String customName;
	
	private static final int PROCESS_TIME = 200;
	private int processTimeRemaining;
	
	public TileOreProcessor()
	{
		this.inventory = new ItemStack[this.getSizeInventory()];
	}
	
	@Override
	public void update()
	{
		boolean markDirty = false;
		ItemStack input = this.getStackInSlot(0);
		
		if(input != null)
		{
			input.stackSize--;
			
			Random random = new Random();
			
			HashMap<ItemElement, MinMax> elements = assignRandomElements(input.getItem()); //Get random elements based on ore
			
			for(ItemElement element : elements.keySet())
			{
				MinMax minMax = elements.get(element);
				//Get random quantity within bounds (inclusive)
				int quantity = random.nextInt(minMax.getMax() +1 - minMax.getMin()) + minMax.getMin();
				
				for(int i = 0; i < quantity; i++)
				{
					//1 = starting output slot TODO make constants
					for (int j = 1; j < inventory.length; j++)
					{
						System.out.println(element + " " + i + " " + j);
						
						ItemStack stack = inventory[j];
						if(stack == null)
						{
							this.setInventorySlotContents(j, new ItemStack(element));
							break;
						}
						else if(stack.getItem() == element && stack.stackSize < 64)
						{
							stack.stackSize++;
							break;
						}
					}
				}
			}
			markDirty = true;
			
			if(input.stackSize == 0)
			{
				input = null;
				this.setInventorySlotContents(0, null);
				markDirty = true;
			}
		}
		
		/*if(this.processTimeRemaining > 0 && this.canProcess()) this.processTimeRemaining--;
		else this.processTimeRemaining = TileOreProcessor.PROCESS_TIME;
		
		if(!this.worldObj.isRemote  && this.canProcess() && this.processTimeRemaining == 0)
		{
			this.setInventorySlotContents(2, new ItemStack(Items.IRON_AXE));
		}*/
		
		if(markDirty) this.markDirty();
	}
	
	/**
	 * Assigns random elements based on the item given, assuming the item is an ore. TODO Move
	 * The quantity of elements is based on the ore's resource map.
	 * @param item The item to assign elements to.
	 * @return A map of assigned elements and quantities
	 */
	private HashMap<ItemElement, MinMax> assignRandomElements(Item item)
	{
		HashMap<ItemElement, MinMax> elements = new HashMap<>();
		
		if(item instanceof ItemBlockOre) //Check item is ore
		{
			Random random = new Random();
			BlockOre ore = ((ItemBlockOre) item).getOre();
			
			for(ItemElement element : ore.getResourceMap().keySet())
			{
				MinMax minMax = ore.getResourceMap().get(element);
				elements.put(element, minMax);
			}
		}
		
		return elements;
	}
	
	private boolean canProcess()
	{
		return true; //TODO Switch to use power (RF)
	}
	
	public ItemStack[] getInventory()
	{
		return this.inventory;
	}
	
	@Override
	public int getSizeInventory()
	{
		return TileOreProcessor.SIZE;
	}
	
	@Nullable
	@Override
	public ItemStack getStackInSlot(int index)
	{
		if (index < 0 || index >= this.getSizeInventory()) return null;
		return this.inventory[index];
	}
	
	@Nullable
	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		if (this.getStackInSlot(index) != null)
		{
			ItemStack itemstack;
			
			if (this.getStackInSlot(index).stackSize <= count)
			{
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return itemstack;
			}
			else
			{
				itemstack = this.getStackInSlot(index).splitStack(count);
				
				if (this.getStackInSlot(index).stackSize <= 0) this.setInventorySlotContents(index, null);
				else this.setInventorySlotContents(index, this.getStackInSlot(index));
				
				this.markDirty();
				return itemstack;
			}
		}
		else return null;
	}
	
	@Nullable
	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}
	
	@Override
	public void setInventorySlotContents(int index, @Nullable ItemStack stack)
	{
		if (index < 0 || index >= this.getSizeInventory()) return;
		
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) stack.stackSize = this.getInventoryStackLimit();
		
		if (stack != null && stack.stackSize == 0) stack = null;
		
		this.inventory[index] = stack;
		this.markDirty();
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	@Override
	public void openInventory(EntityPlayer player)
	{}
	
	@Override
	public void closeInventory(EntityPlayer player)
	{}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		Block block = Block.getBlockFromItem(stack.getItem());
		return(index == 0 && (block instanceof BlockOre || block instanceof net.minecraft.block.BlockOre));
	}
	
	@Override
	public int getField(int id)
	{
		return 0;
	}
	
	@Override
	public void setField(int id, int value)
	{}
	
	@Override
	public int getFieldCount()
	{
		return 0;
	}
	
	@Override
	public void clear()
	{
		for (int i = 0; i < this.getSizeInventory(); i++)this.setInventorySlotContents(i, null);
	}
	
	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.customName : TileOreProcessor.NAME;
	}
	
	@Override
	public boolean hasCustomName()
	{
		return this.customName != null && !this.customName.equals("");
	}
	
	@Override
	public ITextComponent getDisplayName()
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
}
