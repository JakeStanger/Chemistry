package roboguy99.chemistry.gui.container.slot;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import roboguy99.chemistry.block.ore.BlockOre;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class SlotOre extends Slot
{
	public SlotOre(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack)
	{
		Block block = Block.getBlockFromItem(itemStack.getItem());
		return block instanceof BlockOre || block instanceof net.minecraft.block.BlockOre;
	}
}
