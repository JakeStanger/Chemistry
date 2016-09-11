package roboguy99.chemistry.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import roboguy99.chemistry.block.BlockOre;

import javax.annotation.Nullable;

/**
 * @author Jake stanger
 * A TileEntity with an inventory.
 */
public abstract class TileInventory extends TileEntity implements IInventory
{
	private ItemStack[] inventory;
	private String name;
	private String customName;
	
	protected static final int INPUT_SLOT = 0;
	protected static final int OUTPUT_SLOTS_BEGIN = 1;
	
	public TileInventory()
	{
		this.inventory = new ItemStack[this.giveInventorySize()];
		this.name = this.giveName();
	}
	
	protected abstract int giveInventorySize();
	protected abstract String giveName();
	
	public ItemStack[] getInventory()
	{
		return this.inventory;
	}
	
	/**
	 * Gets the first output slot with a null contents.
	 * @return The ID of the slot or -1 if one could not be found.
	 */
	protected int getFirstEmptySlot()
	{
		return this.getFirstEmptySlot(TileInventory.OUTPUT_SLOTS_BEGIN);
	}
	
	/**
	 * Gets the first slot with a null contents.
	 * @param beginSlot The slot ID to begin looking at.
	 * @return The ID of the slot or -1 if one could not be found.
	 */
	protected int getFirstEmptySlot(int beginSlot)
	{
		for (int i = beginSlot; i < this.inventory.length; i++)
		{
			if (this.inventory[i] == null) return i;
		}
		
		return -1;
	}
	
	/**
	 * Gets the first output slot with a contents but with room for more
	 * of the given item.
	 * @param item The item to find a slot for.
	 * @return The ID of the slot or -1 if one could not be found.
	 */
	protected int getFirstSlotWithRoom(Item item)
	{
		return this.getFirstSlotWithRoom(item, TileInventory.OUTPUT_SLOTS_BEGIN);
	}
	
	/**
	 * Gets the first slot with a contents but with room for more
	 * of the given item.
	 * @param item The item to find a slot for.
	 * @param slotBegin The slot ID to begin looking at.
	 * @return The ID of the slot or -1 if one could not be found.
	 */
	protected int getFirstSlotWithRoom(Item item, int slotBegin)
	{
		return this.getFirstSlotWithRoom(item, slotBegin, 1);
	}
	
	/**
	 * Gets the first slot with a contents but with room for more
	 * of the given item.
	 * @param item The item to find a slot for.
	 * @param slotBegin The slot ID to begin looking at.
	 * @param roomRequired The amount of room required in the slot.
	 * @return The ID of the slot or -1 if one could not be found.
	 */
	protected int getFirstSlotWithRoom(Item item, int slotBegin, int roomRequired)
	{
		for(int i = slotBegin; i < this.inventory.length; i++)
		{
			ItemStack stackInSlot = this.inventory[i];
			if(stackInSlot != null && stackInSlot.getItem() == item
					&& (stackInSlot.stackSize-1) + roomRequired < this.getInventoryStackLimit()) return i;
		}
		
		return -1;
	}
	
	/**
	 * Gets the number of slots with a null contents.
	 * @return The number of slots with a null contents.
	 */
	protected int getNumOfEmptySlots()
	{
		int num = 0;
		for(int i = TileInventory.OUTPUT_SLOTS_BEGIN; i < this.inventory.length; i++)
		{
			if(this.getFirstEmptySlot(i) != -1) num++;
		}
		
		return num;
	}
	
	/**
	 * Gets the number of non-null non-full slots containing the given item.
	 * @param item The item to find a slot containing.
	 * @return The number of non-null non-full slots containing the given item.
	 */
	protected int getNumOfSlotsWithRoom(Item item)
	{
		int num = 0;
		for(int i = TileInventory.OUTPUT_SLOTS_BEGIN; i < this.inventory.length; i++)
		{
			if(this.getFirstSlotWithRoom(item, i) != -1) num++;
		}
		
		return num;
	}
	
	/**
	 * Gets the amount of room in the given slot.
	 * @param slot The ID of the slot.
	 * @return The amount of room in the slot.
	 */
	protected int getRoomInSlot(int slot)
	{
		return this.getInventoryStackLimit() - this.inventory[slot].stackSize;
	}
	
	/**
	 * Adds the given ItemStack to the stack already in the slot.
	 * Will only work if there is already a stack in the slot.
	 * Does not check item types.
	 * @param stack The stack to add to the slot.
	 * @param slot The slot to add the stack to.
	 * @return The input stack, with its size adjusted according to how much was placed
	 *          (if the full stack could not be placed, the left-over is returned)
	 */
	protected ItemStack addStackToSlot(ItemStack stack, int slot)
	{
		int room = this.getRoomInSlot(slot);
		
		ItemStack slotStack = this.getStackInSlot(slot);
		
		if(slotStack != null)
		{
			if(room > stack.stackSize)
			{
				slotStack.stackSize += stack.stackSize;
				stack.stackSize = 0;
			}
			else
			{
				slotStack.stackSize += room;
				stack.stackSize -= room;
			}
		}
		
		return stack;
	}
	
	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
	}
	
	@Nullable
	@Override
	public ItemStack getStackInSlot(int index)
	{
		if (index < 0 || index >= this.getSizeInventory()) return null;
		return this.inventory[index];
	}
	
	@SuppressWarnings("ConstantConditions")
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
	
	@SuppressWarnings("NullableProblems")
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	@SuppressWarnings("NullableProblems")
	@Override
	public void openInventory(EntityPlayer player)
	{}
	
	@SuppressWarnings("NullableProblems")
	@Override
	public void closeInventory(EntityPlayer player)
	{}
	
	@SuppressWarnings("NullableProblems")
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		Block block = Block.getBlockFromItem(stack.getItem());
		return(index == 0 && (block instanceof BlockOre || block instanceof net.minecraft.block.BlockOre));
	}
	
	@Override
	public abstract int getField(int id);
	
	@Override
	public abstract void setField(int id, int value);
	
	@Override
	public abstract int getFieldCount();
	
	@Override
	public void clear()
	{
		for (int i = 0; i < this.getSizeInventory(); i++)this.setInventorySlotContents(i, null);
	}
	
	@SuppressWarnings({"ConstantConditions", "NullableProblems"})
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
			if (this.getStackInSlot(i) != null)
			{
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("items", list);
		
		if (this.hasCustomName()) nbt.setString("customName", this.getCustomName());
		
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("items", 10);
		for (int i = 0; i < list.tagCount(); ++i)
		{
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}
		
		if (nbt.hasKey("customName", 8)) this.setCustomName(nbt.getString("customName"));
	}
	
	private String getCustomName()
	{
		return this.customName;
	}
	
	private void setCustomName(String customName)
	{
		this.customName = customName;
	}
	
	@SuppressWarnings("NullableProblems")
	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.customName : this.name;
	}
	
	@Override
	public boolean hasCustomName()
	{
		return this.customName != null && !this.customName.equals("");
	}
	
	@SuppressWarnings("NullableProblems")
	@Override
	public ITextComponent getDisplayName()
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
}
