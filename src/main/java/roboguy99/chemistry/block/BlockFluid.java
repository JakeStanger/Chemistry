package roboguy99.chemistry.block;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class BlockFluid extends BlockFluidClassic
{
	public BlockFluid(String name, Fluid fluid)
	{
		super(fluid, Material.WATER);
		
		this.setCreativeTab(Chemistry.tabMachines);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		GameRegistry.register(this);
		
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		GameRegistry.register(itemBlock);
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos blockPos)
	{
		return !world.getBlockState(blockPos).getMaterial().isLiquid() && super.canDisplace(world, blockPos);
	}
	
	@Override
	public boolean displaceIfPossible(World world, BlockPos blockPos)
	{
		return !world.getBlockState(blockPos).getMaterial().isLiquid() && super.displaceIfPossible(world, blockPos);
	}
}
