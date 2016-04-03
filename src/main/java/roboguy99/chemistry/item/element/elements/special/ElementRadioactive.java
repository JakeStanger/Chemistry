package roboguy99.chemistry.item.element.elements.special;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumColour;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.network.packet.ItemDelete;

public abstract class ElementRadioactive extends Element
{
	private static final int TICKS_PER_MINUTE = 120; //1 Minecraft minute
	
	/**
	 * The half-life of the element, in minutes
	 */
	private long halfLife;
	
	/**
	 * The number of ticks until the next MC minute is up.
	 */
	private int ticksUntilUpdate = 1; //Update straight away
	
	public ElementRadioactive()
	{
		this.halfLife = this.giveHalfLife();
	}	
	
	public long getHalfLife()
	{
		return this.halfLife;
	}
	
	/**
	 * The half-life of the element, in minutes
	 * @return
	 */
	public abstract long giveHalfLife();
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) 
	{		
		this.ticksUntilUpdate--;
		if(this.ticksUntilUpdate <= 0)
		{
			long timeUntilDecay;
			
			if(stack.getTagCompound() != null) timeUntilDecay = stack.getTagCompound().getLong("timeUntilDecay");
			else timeUntilDecay = this.halfLife;
			
			this.ticksUntilUpdate = this.TICKS_PER_MINUTE;
			
			timeUntilDecay--;
			this.updateNBT(stack, timeUntilDecay);
			
			if(timeUntilDecay <= 0)
			{
				timeUntilDecay = this.halfLife;
				this.updateNBT(stack, timeUntilDecay);
				
				Math.floor(stack.stackSize /= 2F);
				
				if(stack.stackSize <= 0) Chemistry.getNetworkWrapper().sendToServer(new ItemDelete(stack));
			}
		}
	}
	
	/**
	 * Adds the given time until delay to the given item in a new tag
	 * @param stack the itemstack to update the NBT of
	 * @param timeUntilDecay the value to write to NBT
	 */
	private void updateNBT(ItemStack stack, long timeUntilDecay)
	{
		NBTTagCompound tag = new NBTTagCompound();
		tag.setLong("timeUntilDecay", timeUntilDecay);
		stack.setTagCompound(tag);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		super.addInformation(stack, player, tooltip, advanced);
		if(Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode()))
		{
			try
			{
				tooltip.add(EnumColour.BRIGHT_GREEN + "Radioactive: " + this.getDecayTimeReadable(stack.getTagCompound().getLong("timeUntilDecay")) + " until decay");
			}
			catch(NullPointerException e)
			{
				tooltip.add(EnumColour.BRIGHT_GREEN + "Radioactive: " + this.getDecayTimeReadable(this.halfLife) + " until decay");
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
