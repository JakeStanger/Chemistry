package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import roboguy99.chemistry.gui.container.slot.SlotElement;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class ContainerBlockCompoundCreator extends Container
{
	private TileCompoundCreator compoundCreator;
	
	public ContainerBlockCompoundCreator(EntityPlayer player, InventoryPlayer inventoryPlayer, TileCompoundCreator compoundCreator)
	{
		this.compoundCreator = compoundCreator;
		
		//Entity slots
		for(int y = 0; y < 7; y++)
		{
			for(int x = 0; x < 9; x++) this.addSlotToContainer(new SlotElement(compoundCreator, x + y * 9, 8 + x*18, 5 + y*18));
		}
		
		//Player inventory
	    for(int y = 0; y < 3; y++) 
	    {
	        for(int x = 0; x < 9; x++) this.addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + x * 18, 159 + y * 18));
	    }

	    //Player hotbar
	    for(int x = 0; x < 9; x++) 
	    {
	        this.addSlotToContainer(new Slot(inventoryPlayer, x, 8 + x * 18, 217));
	    }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.compoundCreator.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) 
	{
	    ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) 
	    {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        //Custom behaviour

	        if (current.stackSize == 0)slot.putStack((ItemStack) null);
	        else slot.onSlotChanged();

	        if (current.stackSize == previous.stackSize) return null;
	        slot.onPickupFromSlot(playerIn, current);
	    }
	    return previous;
	}
	
	public BlockPos getTilePos()
	{
		return this.compoundCreator.getPos();
	}
}
