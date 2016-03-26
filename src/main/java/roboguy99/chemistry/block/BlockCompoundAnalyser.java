package roboguy99.chemistry.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.tileentity.TileCompoundAnalyser;

public class BlockCompoundAnalyser extends BlockContainer
{
	public BlockCompoundAnalyser() 
	{
		super(Material.iron);
		this.setCreativeTab(Chemistry.tabElements);
		GameRegistry.registerBlock(this, "blockCompoundMaker");
	}

	public int getRenderType()
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
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		//Open GUI
		return true;
	}
}
