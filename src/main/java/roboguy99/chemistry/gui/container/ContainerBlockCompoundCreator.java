package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBlockCompoundCreator extends Container
{
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return false;
	}
}
