package roboguy99.chemistry.handler;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CompoundCreationHandler
{
	public static void createCompound(EntityPlayer player, List<ItemStack> inventory)
	{
		System.out.println(inventory);
	}
}
