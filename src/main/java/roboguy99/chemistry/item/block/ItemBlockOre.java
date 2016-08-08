package roboguy99.chemistry.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import roboguy99.chemistry.block.ore.BlockOre;

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
