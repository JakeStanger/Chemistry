package roboguy99.chemistry.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import roboguy99.chemistry.gui.GuiBlockCompoundCreator;
import roboguy99.chemistry.gui.container.ContainerBlockCompoundCreator;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class GuiHandler implements IGuiHandler
{
	private static int guiId = 0;
	public static final int GUI_BLOCK_COMPOUND_CREATOR = guiId;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GUI_BLOCK_COMPOUND_CREATOR) return new ContainerBlockCompoundCreator(player, player.inventory, (TileCompoundCreator) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileCompoundCreator tile = (TileCompoundCreator) world.getTileEntity(new BlockPos(x, y, z));
		if (ID == GUI_BLOCK_COMPOUND_CREATOR) return new GuiBlockCompoundCreator(new ContainerBlockCompoundCreator(player, player.inventory, tile), tile);
		return null;
	}
}
