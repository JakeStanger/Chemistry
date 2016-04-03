package roboguy99.chemistry.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ItemDelete implements IMessage
{
	private ItemStack stack;
	
	public ItemDelete()
	{}
	
	public ItemDelete(ItemStack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.stack = ByteBufUtils.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeItemStack(buf, stack);
	}
	
	public static class ItemDeleteHandle implements IMessageHandler<ItemDelete, IMessage>
	{
		@Override
        public IMessage onMessage(final ItemDelete message, final MessageContext ctx) 
		{
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() 
            {
                @Override
                public void run() 
                {
                	ItemStack stack = message.stack;
                	stack.useItemRightClick(ctx.getServerHandler().playerEntity.worldObj, ctx.getServerHandler().playerEntity);
                	stack = null; //TODO Fix this
                }
            });
            return null;
        }
	}
}