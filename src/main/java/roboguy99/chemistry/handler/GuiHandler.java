package roboguy99.chemistry.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import roboguy99.chemistry.gui.GuiCompoundCreator;
import roboguy99.chemistry.gui.GuiOreProcessor;
import roboguy99.chemistry.gui.GuiRefinery;
import roboguy99.chemistry.gui.container.ContainerCompoundCreator;
import roboguy99.chemistry.gui.container.ContainerOreProcessor;
import roboguy99.chemistry.gui.container.ContainerRefinery;
import roboguy99.chemistry.tile.TileCompoundCreator;
import roboguy99.chemistry.tile.TileOreProcessor;
import roboguy99.chemistry.tile.TileRefinery;

public class GuiHandler implements IGuiHandler
{
	//private static int guiId = 0;
	public static final int GUI_COMPOUND_CREATOR = 0; //TODO Move to enum
	public static final int GUI_ORE_PROCESSOR = 1;
	public static final int GUI_REFINERY = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID)
		{
			case GUI_COMPOUND_CREATOR:
				return new ContainerCompoundCreator(player.inventory, (TileCompoundCreator) tile);
			case GUI_ORE_PROCESSOR:
				return new ContainerOreProcessor(player.inventory, (TileOreProcessor) tile);
			case GUI_REFINERY:
				return new ContainerRefinery(player.inventory, (TileRefinery) tile);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID)
		{
			case GUI_COMPOUND_CREATOR:
				return new GuiCompoundCreator(new ContainerCompoundCreator(player.inventory, (TileCompoundCreator) tile), (TileCompoundCreator) tile);
			case GUI_ORE_PROCESSOR:
				return new GuiOreProcessor(new ContainerOreProcessor(player.inventory, (TileOreProcessor) tile), (TileOreProcessor) tile);
			case GUI_REFINERY:
				return new GuiRefinery(new ContainerRefinery(player.inventory, (TileRefinery) tile), (TileRefinery) tile);
			default:
				return null;
		}
	}
}
