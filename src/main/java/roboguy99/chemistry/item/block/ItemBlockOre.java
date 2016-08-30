package roboguy99.chemistry.item.block;

import net.minecraft.item.ItemBlock;
import roboguy99.chemistry.block.ore.BlockOre;

/**
 * A custom ItemBlock for ores, making it possible to get the ore block from Item/ItemStack instances
 * @author Jake Stanger
 *
 */
public class ItemBlockOre extends ItemBlock
{
	private BlockOre ore;
	
	public ItemBlockOre(BlockOre block)
	{
		super(block);
		this.ore = block;
	}
	
	public BlockOre getOre()
	{
		return this.ore;
	}
}
