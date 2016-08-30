package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import roboguy99.chemistry.gui.container.slot.SlotOre;
import roboguy99.chemistry.gui.container.slot.SlotOreOutput;
import roboguy99.chemistry.tile.TileOreProcessor;


/**
 * @author Jake stanger
 * TODO Write JavaDoc
 */
public class ContainerBlockOreProcessor extends Container
{
	private TileOreProcessor oreProcessor;
	
	public ContainerBlockOreProcessor(InventoryPlayer inventoryPlayer, TileOreProcessor oreProcessor)
	{
		this.oreProcessor = oreProcessor;
		
		//Input slot
		this.addSlotToContainer(new SlotOre(oreProcessor, 0, 8, 27));
		
		//Output slots
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 6; x++) this.addSlotToContainer(new SlotOreOutput(oreProcessor, x + y * 9 + 1, 62 + x * 18, 9 + y * 18));
		}
		
		//Player inventory
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++) this.addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + x * 18, 74 + y * 18));
		}
		
		//Player hotbar
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, x, 8 + x * 18, 132));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.oreProcessor.isUseableByPlayer(player);
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
	
	public BlockPos getTilePos()
	{
		return this.oreProcessor.getPos();
	}
}
