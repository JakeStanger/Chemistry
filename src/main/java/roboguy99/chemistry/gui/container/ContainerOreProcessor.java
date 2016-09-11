package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import roboguy99.chemistry.gui.container.slot.SlotOre;
import roboguy99.chemistry.gui.container.slot.SlotOutput;
import roboguy99.chemistry.tile.TileMachine;


/**
 * @author Jake stanger
 * Container class for OreProcessor machine.
 */
public class ContainerOreProcessor extends ContainerMachine
{
	public ContainerOreProcessor(InventoryPlayer inventoryPlayer, TileMachine tileMachine)
	{
		super(inventoryPlayer, tileMachine);
		
		//Input slot
		this.addSlotToContainer(new SlotOre(tileMachine, 0, 8, 27));
		
		//Output slots
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 6; x++) this.addSlotToContainer(new SlotOutput(tileMachine, x + y * 6 + 1, 62 + x * 18, 9 + y * 18));
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot)
	{
		ItemStack previous = null;
		Slot slot = this.inventorySlots.get(fromSlot);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack current = slot.getStack();
			previous = current.copy();
			
			//Custom behaviour
			if (current.stackSize == 0) slot.putStack(null);
			else slot.onSlotChanged();
			
			if (current.stackSize == previous.stackSize) return null;
			slot.onPickupFromSlot(playerIn, current);
		}
		return previous;
	}
}
