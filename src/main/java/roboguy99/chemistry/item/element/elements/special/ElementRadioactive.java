package roboguy99.chemistry.item.element.elements.special;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import roboguy99.chemistry.api.Colour;
import roboguy99.chemistry.api.TimeFormatter;
import roboguy99.chemistry.item.element.ItemElement;

import java.util.List;

/**
 * A radioactive element.
 * Unlike the base element, this includes a half-life system.
 * The half-life is in Minecraft minutes, and once it runs out the parent ItemStack halves in size.
 * This is rounded down, so a stack of 3 will decay to a stack of 1, and a stack of 1 will be deleted.
 * One Minecraft minute is equal to 1/20 of a real minute (3 real seconds).
 * @author Jake Stanger
 *
 */
public abstract class ElementRadioactive extends ItemElement
{
	/**
	 * The half-life of the element, in minutes
	 */
	private long HALF_LIFE;
	
	/**
	 * The time between decay updates in milliseconds
	 */
	private static final int UPDATE_GAP = 1000;
	
	
	public ElementRadioactive()
	{
		this.HALF_LIFE = this.giveHalfLife();
	}	
	
	
	/**
	 * The half-life of the element, in minutes.
	 */
	public abstract long giveHalfLife();
	
	/**
	 * Runs when the item ticks.
	 * Updates half-life.
	 * @param stack The ItemStack
	 * @param world The World
	 * @param entity The player
	 * @param par4 ?
	 * @param par5 ?
	 */
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		if(!world.isRemote)
		{
			NBTTagCompound compound;
			if (stack.getTagCompound() != null) compound = stack.getTagCompound();
			else compound = new NBTTagCompound();
			
			long startTime;
			if (compound.hasKey("startDecayTick")) startTime = compound.getLong("startDecayTick");
			else
			{
				startTime = System.currentTimeMillis();
				compound.setLong("startDecayTick", startTime);
			}
			
			long currentTime = System.currentTimeMillis();
			
			if (currentTime - startTime >= ElementRadioactive.UPDATE_GAP) //Reduce decay time every 3 seconds
			{
				compound.removeTag("startDecayTick");
				
				long timeUntilDecay;
				
				if (compound.hasKey("timeUntilDecay"))
				{
					timeUntilDecay = compound.getLong("timeUntilDecay");
					timeUntilDecay--;
					compound.setLong("timeUntilDecay", timeUntilDecay);
				}
				else
				{
					timeUntilDecay = this.HALF_LIFE;
					compound.setLong("timeUntilDecay", timeUntilDecay);
				}
				
				if (timeUntilDecay <= 0)
				{
					timeUntilDecay = this.HALF_LIFE;
					compound.setLong("timeUntilDecay", timeUntilDecay);
					
					stack.stackSize = (int) Math.floor(stack.stackSize / 2F); //Reduce stack size
					if (stack != null && stack.stackSize == 0)
					{
						EntityPlayer player = (EntityPlayer) entity;
						if(player != null) player.inventory.deleteStack(stack);
					}
				}
			}
			
			stack.setTagCompound(compound);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		super.addInformation(stack, player, tooltip, advanced);
		if(Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode()))
		{
			TimeFormatter timeFormatter = new TimeFormatter();
			
			long time;
			
			NBTTagCompound compound = stack.getTagCompound();
			if(compound != null && compound.hasKey("timeUntilDecay")) time = compound.getLong("timeUntilDecay");
			else time = this.HALF_LIFE;
			
			tooltip.add(Colour.BRIGHT_GREEN + "Radioactive: " + timeFormatter.format(time) + " until decay");
		}
	}
}
