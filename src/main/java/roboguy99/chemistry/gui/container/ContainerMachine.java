package roboguy99.chemistry.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.tile.TileMachine;

/**
 * @author Jake stanger
 * A container for a TileEntity with an inventory and energy buffer.
 */
public class ContainerMachine extends Container
{
	protected TileMachine tileMachine;
	protected int[] progressBarValues;
	
	public ContainerMachine(InventoryPlayer inventoryPlayer, TileMachine tileMachine)
	{
		this.tileMachine = tileMachine;
		this.progressBarValues = new int[tileMachine.getFieldCount()];
		this.addSlots(inventoryPlayer);
		System.out.println(FMLCommonHandler.instance().getEffectiveSide());
	}
	
	protected void addSlots(InventoryPlayer inventoryPlayer)
	{
		//Player inventory
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++) this.addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + x * 18, 74 + y * 18));
		}
		
		//Player hotbar
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, x, 8 + x * 18, 132));
		}
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for (IContainerListener icontainerlistener : this.listeners)
		{
			for(int i = 0; i < progressBarValues.length; i++)
			{
				if(this.progressBarValues[i] != this.tileMachine.getField(i))
				{
					icontainerlistener.sendProgressBarUpdate(this, i, this.tileMachine.getField(i));
				}
				
				this.progressBarValues[i] = this.tileMachine.getField(i);
			}
		}
	}
	
	@Override
	public void addListener(IContainerListener listener)
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileMachine);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int data)
	{
		this.tileMachine.setField(id, data);
	}
	
	@SuppressWarnings("NullableProblems")
	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return this.tileMachine.isUseableByPlayer(playerIn);
	}
}
