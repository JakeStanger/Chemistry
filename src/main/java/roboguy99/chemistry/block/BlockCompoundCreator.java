package roboguy99.chemistry.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.handler.GuiHandler;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class BlockCompoundCreator extends BlockContainer
{
	public BlockCompoundCreator() 
	{
		super(Material.IRON);
		this.setCreativeTab(Chemistry.tabMachines);
		//this.setBlockBounds(0.095F, 0F, 0.095F, 0.905F, 0.825F, 0.905F); //TODO Ask about this
		this.setUnlocalizedName("blockCompoundCreator");
		GameRegistry.register(this);
	}
	
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) 
	{
	    TileCompoundCreator te = (TileCompoundCreator) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	}


	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
	    if (stack.hasDisplayName()) 
	    {
	        ((TileCompoundCreator) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}

	/*@Override
	public int getRenderType()
	{
		return 3;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}*/
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2) 
	{
		return new TileCompoundCreator();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)player.openGui(Chemistry.INSTANCE, GuiHandler.GUI_BLOCK_COMPOUND_CREATOR, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
