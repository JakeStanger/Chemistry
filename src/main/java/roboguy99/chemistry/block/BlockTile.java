package roboguy99.chemistry.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.tile.TileCompoundCreator;

/**
 * A block which has an associated TileEntity
 * @author Roboguy99
 *
 */
public abstract class BlockTile extends BlockContainer
{
	private Class tile;
	
	protected BlockTile(Material materialIn, String name, CreativeTabs creativeTab, Class<? extends TileEntity> tile) 
	{
		super(materialIn);
		
		this.tile = tile;
		
		this.setCreativeTab(creativeTab);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		GameRegistry.register(this);
		
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		GameRegistry.register(itemBlock);
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
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2) 
	{
		try 
		{
			return (TileEntity) this.tile.newInstance();
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public abstract boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ);
}
