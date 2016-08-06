package roboguy99.chemistry.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.tile.TileCompoundCreator;
import roboguy99.chemistry.tile.TileOreProcessor;

public class BlockOreProcessor extends BlockTile
{
	protected BlockOreProcessor(Material materialIn) 
	{
		super(Material.IRON, "blockOreProcessor", Chemistry.tabMachines, TileOreProcessor.class);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote) 
		{
			player.addChatMessage(new TextComponentString("Test"));
		}
		return true;
	}
}
