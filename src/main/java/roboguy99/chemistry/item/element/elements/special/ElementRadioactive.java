package roboguy99.chemistry.item.element.elements.special;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import roboguy99.chemistry.api.Colour;
import roboguy99.chemistry.item.element.ItemElement;

import java.util.List;

/**
 * A radioactive element.
 * Unlike the base element, this includes a half-life system.
 * The half-life is in Minecraft minutes, and once it runs out the parent itemstack halves in size.
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
	private static final int UPDATE_GAP = 3000;
	
	
	public ElementRadioactive()
	{
		this.HALF_LIFE = this.giveHalfLife();
	}	
	
	/**
	 * Get the half-life of the element.
	 * @return The half-life of the element, in minutes.
	 */
	public long getHALF_LIFE()
	{
		return this.HALF_LIFE;
	}
	
	/**
	 * The half-life of the element, in minutes.
	 */
	public abstract long giveHalfLife();
	
	/**
	 * Runs when the item ticks.
	 * Updates half-life.
	 * @param stack
	 * @param world
	 * @param entity
	 * @param par4
	 * @param par5
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
						EntityPlayer player = Minecraft.getMinecraft().thePlayer;
						if(player != null)
						{
							player.inventory.deleteStack(stack);
							//int slot = Minecraft.getMinecraft().thePlayer.inventory.getSlotFor(stack);
							//if(slot >= 0) player.inventory.setInventorySlotContents(slot, null);
						}
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
			try
			{
				tooltip.add(Colour.BRIGHT_GREEN + "Radioactive: " + this.getDecayTimeReadable(stack.getTagCompound().getLong("timeUntilDecay")) + " until decay");
			}
			catch(NullPointerException e)
			{
				tooltip.add(Colour.BRIGHT_GREEN + "Radioactive: " + this.getDecayTimeReadable(this.HALF_LIFE) + " until decay");
			}
		}
	}
	
	/**
	 * Scale the units of the given decay time into a more suitable unit.
	 * For example 60 minutes is converted to 1 hour.
	 * This will scale up to billions of years.
	 * @param decayTime The time until the element decays
	 * @return The time until the element decays, in a more readable format
	 */
	private String getDecayTimeReadable(long decayTime)
	{
		String readable = decayTime + " minutes";
		if(decayTime > 60)
		{
			decayTime /= 60;
			readable = decayTime + " hours";
			
			if(decayTime > 24)
			{
				decayTime /= 24;
				readable = decayTime + " days";
				
				if(decayTime > 365)
				{
					decayTime /=365;
					readable = decayTime + " years";
					
					if(decayTime > 1000000)
					{
						decayTime /= 1000000;
						readable = decayTime + "mn years";
						
						if(decayTime > 1000)
						{
							decayTime /= 1000;
							readable = decayTime + "bn years"; 
						}
					}
				}
			}
		}
		
		if(decayTime == 1) readable = readable.substring(0, readable.length()-1); //Remove plural
		
		return readable;
	}
}
