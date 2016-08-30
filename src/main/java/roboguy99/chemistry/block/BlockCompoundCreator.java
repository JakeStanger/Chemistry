package roboguy99.chemistry.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.handler.GuiHandler;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class BlockCompoundCreator extends BlockTile
{
	public BlockCompoundCreator() 
	{
		super(Material.IRON, "blockCompoundCreator", Chemistry.tabMachines, TileCompoundCreator.class);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote) player.openGui(Chemistry.INSTANCE, GuiHandler.GUI_BLOCK_COMPOUND_CREATOR, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.095, 0, 0.095, 0.905, 0.825, 0.905);
    }
}
