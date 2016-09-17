package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import roboguy99.chemistry.tile.TileRefinery;

/**
 * @author Jake stanger
 * Container for the refinery TileEntity
 */
public class ContainerRefinery extends ContainerMachine
{
	public ContainerRefinery(InventoryPlayer inventoryPlayer, TileRefinery tileMachine)
	{
		super(inventoryPlayer, tileMachine.getHost());
		this.progressBarValues = new int[tileMachine.getFieldCount()];
	}
	
	@Override
	protected void addSlots(InventoryPlayer inventoryPlayer)
	{
		//Player inventory
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++) this.addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 25 + x * 18, 106 + y * 18));
		}
		
		//Player hotbar
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, x, 25 + x * 18, 164));
		}
	}
}
