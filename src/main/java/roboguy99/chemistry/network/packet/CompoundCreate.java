package roboguy99.chemistry.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import roboguy99.chemistry.handler.CompoundCreationHandler;

public class CompoundCreate implements IMessage
{	
	private BlockPos pos;
	
	public CompoundCreate()
	{}
	
	public CompoundCreate(BlockPos pos)
	{
		this.pos = pos;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		
		this.pos = new BlockPos(x, y, z);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.pos.getX());
		buf.writeInt(this.pos.getY());
		buf.writeInt(this.pos.getZ());
	}
	
	public static class CompoundCreateHandle implements IMessageHandler<CompoundCreate, IMessage>
	{
		@Override
        public IMessage onMessage(final CompoundCreate message, final MessageContext ctx) 
		{
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
            mainThread.addScheduledTask(() -> CompoundCreationHandler.createCompound(ctx.getServerHandler().playerEntity, message.pos));
            return null;
        }
	}
}
