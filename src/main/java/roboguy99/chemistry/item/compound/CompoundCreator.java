package roboguy99.chemistry.item.compound;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.network.packet.CompoundCreate;

/**
 * TODO Properly implement this
 * @author Roboguy99
 */
public class CompoundCreator
{
	private List<Element> elements = new ArrayList<Element>();
	
	/**
	 * Create a compound from the elements put into the elements list
	 * TODO Check for null list and throw custom exception
	 * @return an itemstack for the compound
	 */
	public ItemStack createCompound()
	{
		Compound compound = Compound.instance;
		NBTTagCompound tag = new NBTTagCompound();
		
		int elementNumber = 0; //The number of different elements into the list the current one is
		int elementQuantity = 0; //The number of times the current element has occurred in a row
		for(int i = 0; i < elements.size(); i++)
		{
			Element element = elements.get(i);
			
			if(i > 0 && elements.get(i-1).getAtomicNumber() != element.getAtomicNumber())
			{
				elementNumber++;
				elementQuantity = 1;
			}
			else elementQuantity++;
			
			tag.setIntArray(Integer.toString(element.getAtomicNumber()), new int[]{elementNumber, elementQuantity});
		}
		
		ItemStack stack = new ItemStack(compound);
		
		Chemistry.networkWrapper.sendToServer(new CompoundCreate(stack, tag));
		
		return stack;
	}
	
	public void putElement(Element element)
	{
		this.elements.add(element);
	}
	
	public void putElement(Element element, int quantity)
	{
		for(int i = 0; i < quantity; i++) this.elements.add(element);
	}
	
	public List<Element> getElements()
	{
		return this.elements;
	}
	
	public void clearElements()
	{
		this.elements.clear();
	}
}
