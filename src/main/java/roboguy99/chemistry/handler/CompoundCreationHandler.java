package roboguy99.chemistry.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import roboguy99.chemistry.item.compound.CompoundBuilder;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class CompoundCreationHandler
{
	public static void createCompound(EntityPlayer player, BlockPos tilePos)
	{
		TileCompoundCreator tile = (TileCompoundCreator) player.worldObj.getTileEntity(tilePos);
		
		CompoundBuilder compound = new CompoundBuilder();
		
		//The inventory array is backwards, which is annoying.
		for(int i = tile.getSizeInventory(); i >= 0; i--) if(tile.getStackInSlot(i) != null) compound.putElement((Element) tile.getStackInSlot(i).getItem());
		player.inventory.addItemStackToInventory(compound.createCompound(false));
		
		tile.clear();
	}
}
