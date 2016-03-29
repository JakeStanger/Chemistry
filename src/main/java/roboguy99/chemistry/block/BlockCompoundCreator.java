package roboguy99.chemistry.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.compound.CompoundBuilder;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class BlockCompoundCreator extends Block/*extends BlockContainer*/
{
	public BlockCompoundCreator() 
	{
		super(Material.iron);
		this.setCreativeTab(Chemistry.tabElements);
		GameRegistry.registerBlock(this, "blockCompoundMaker");
	}

	/*public int getRenderType()
	{
		return -1;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public TileEntity createNewTileEntity(World world, int var2) 
	{
		return new TileCompoundAnalyser();
	}*/
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			CompoundBuilder compoundHandler = new CompoundBuilder();
			
			//Build compound
			
			compoundHandler.putElements(compoundHandler.getElements(), 2);
				
			ItemStack stack = compoundHandler.createCompound(false);
		}
		return true;
	}
}
