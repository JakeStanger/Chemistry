package roboguy99.chemistry.handler;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import roboguy99.chemistry.api.CompoundBuilder;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Elements.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.elements.special.MoleculeMarker;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class CompoundCreationHandler
{
	public static void createCompound(EntityPlayer player, BlockPos tilePos)
	{
		TileCompoundCreator tile = (TileCompoundCreator) player.worldObj.getTileEntity(tilePos);
		
		CompoundBuilder compound = new CompoundBuilder();

		for(int i = 0; i < tile.getSizeInventory(); i++)
		{
			if(tile.getStackInSlot(i) != null)
			{
				if(!(tile.getStackInSlot(i).getItem() instanceof MoleculeMarker)) compound.putElement((Element) tile.getStackInSlot(i).getItem());
				else compound.endMolecule();
			}
		}
		player.inventory.addItemStackToInventory(compound.createCompound(false));
		
		tile.clear();
	}
}
