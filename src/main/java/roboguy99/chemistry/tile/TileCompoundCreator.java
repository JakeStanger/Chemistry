package roboguy99.chemistry.tile;

import com.sun.org.apache.bcel.internal.Constants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import roboguy99.chemistry.item.element.Element;

public class TileCompoundCreator extends TileEntity implements IInventory
{	
	private static final int SIZE = 63;
	private static final String NAME = "tileCompoundCreator.inventory";
	
	private ItemStack[] inventory;
	private String customName;
	
	public TileCompoundCreator()
	{
		this.inventory = new ItemStack[this.getSizeInventory()];
	}
	
	public ItemStack[] getInventory()
	{
		return this.inventory;
	}
	
	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.customName : this.NAME;
	}

	@Override
	public boolean hasCustomName()
	{
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory()
	{
		return this.SIZE;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		if (index < 0 || index >= this.getSizeInventory()) return null;
	    return this.inventory[index];
	}

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

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		ItemStack stack = this.getStackInSlot(index);
	    this.setInventorySlotContents(index, null);
	    return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
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
		return 1;
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
		return stack.getItem() instanceof Element;
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
	public void writeToNBT(NBTTagCompound nbt) 
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

	    if (nbt.hasKey("customName", 8)) {
	        this.setCustomName(nbt.getString("customName"));
	    }
	}
	
	private String getCustomName()
	{
		return this.customName;
	}
	
	public void setCustomName(String customName)
	{
		this.customName = customName;
	}
}