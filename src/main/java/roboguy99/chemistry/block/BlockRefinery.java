package roboguy99.chemistry.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.handler.GuiHandler;
import roboguy99.chemistry.tile.TileRefinery;

/**
 * @author Jake stanger
 * The block for the refinery
 */
public class BlockRefinery extends BlockTile
{
	public BlockRefinery()
	{
		super(Material.IRON, "blockRefinery", Chemistry.tabMachines, TileRefinery.class);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote) player.openGui(Chemistry.INSTANCE, GuiHandler.GUI_REFINERY, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
