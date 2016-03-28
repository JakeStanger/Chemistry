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

public class CompoundCreate implements IMessage
{
	private ItemStack compound;
	private NBTTagCompound tag;
	
	public CompoundCreate()
	{}
	
	public CompoundCreate(ItemStack compound, NBTTagCompound tag)
	{
		this.compound = compound;
		this.tag = tag;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.compound = ByteBufUtils.readItemStack(buf);
		this.tag = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeItemStack(buf, compound);
		ByteBufUtils.writeTag(buf, tag);
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
                	ItemStack compound = message.compound;
                	NBTTagCompound tag = message.tag;
                	
                	compound.setTagCompound(tag);
                   
                   //Return stack...?
                }
            });
            return null;
        }
	}
}
