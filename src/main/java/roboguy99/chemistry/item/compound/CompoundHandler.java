package roboguy99.chemistry.item.compound;

import java.util.LinkedHashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import roboguy99.chemistry.item.element.Element;

/**
 * TODO Properly implement this
 * @author Roboguy99
 *
 */
public class CompoundHandler
{
	/**
	 * Create a compound from the specified elements
	 * @param elements a LinkedHashMap for each element and its quantity
	 * @return an itemstack for the compound
	 */
	public ItemStack createCompound(LinkedHashMap<Element, Integer> elements)
	{
		Compound compound = Compound.instance;
		NBTTagCompound tag = new NBTTagCompound();
		
		for(Element element : elements.keySet()) tag.setInteger(Integer.toString(element.getAtomicNumber()), elements.get(element));
		
		ItemStack stack = new ItemStack(compound);
		stack.setTagCompound(tag);
		
		return stack;
	}
}
