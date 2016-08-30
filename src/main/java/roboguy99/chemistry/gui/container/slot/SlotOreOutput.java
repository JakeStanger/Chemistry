package roboguy99.chemistry.gui.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class SlotOreOutput extends Slot
{
	public SlotOreOutput(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack)
	{
		return false;
	}
}
