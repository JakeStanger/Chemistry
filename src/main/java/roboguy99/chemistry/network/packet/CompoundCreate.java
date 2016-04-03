package roboguy99.chemistry.network.packet;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import roboguy99.chemistry.handler.CompoundCreationHandler;

public class CompoundCreate implements IMessage
{
	private List<ItemStack> stackArr = new ArrayList<ItemStack>();
	private IInventory inventory;
	
	public CompoundCreate()
	{}
	
	public CompoundCreate(IInventory inventory)
	{
		this.inventory = inventory;

		for(int i = 0; i < inventory.getSizeInventory(); i++)
		{
			if(inventory.getStackInSlot(i) != null) this.stackArr.add(inventory.getStackInSlot(i));
		}
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		for(int i = 0; i < this.inventory.getSizeInventory(); i++) if(ByteBufUtils.readItemStack(buf) != null) this.stackArr.add(ByteBufUtils.readItemStack(buf));
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		for(int i = 0; i < stackArr.size(); i++) if(this.stackArr.get(i) != null) ByteBufUtils.writeItemStack(buf, stackArr.get(i));
	}
	
	public static class CompoundCreateHandle implements IMessageHandler<CompoundCreate, IMessage>
	{
		@Override
        public IMessage onMessage(final CompoundCreate message, final MessageContext ctx) 
		{
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() 
            {
                @Override
                public void run() 
                {
                	List<ItemStack> inventory = message.stackArr;
                   
                	CompoundCreationHandler.createCompound(ctx.getServerHandler().playerEntity, inventory);
                }
            });
            return null;
        }
	}
}
