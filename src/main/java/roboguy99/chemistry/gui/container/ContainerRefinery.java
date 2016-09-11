package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.InventoryPlayer;
import roboguy99.chemistry.tile.TileRefinery;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class ContainerRefinery extends ContainerMachine
{
	public ContainerRefinery(InventoryPlayer inventoryPlayer, TileRefinery tileMachine)
	{
		super(inventoryPlayer, tileMachine);
		this.progressBarValues = new int[tileMachine.getFieldCount()];
	}
}
