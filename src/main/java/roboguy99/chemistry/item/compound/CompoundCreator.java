package roboguy99.chemistry.item.compound;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;
import roboguy99.chemistry.network.packet.CompoundCreate;

/**
 * TODO Properly implement this
 * @author Roboguy99
 */
public class CompoundCreator
{
	private List<Element> elements = new ArrayList<Element>();
	
	/**
	 * Creates a compound from the elements put into the elements list
	 * TODO Check for null list and throw custom exception
	 * @param preserveAfterCreation should the compound in buffer be reset after creation?
	 * @return an itemstack for the compound
	 */
	public ItemStack createCompound(boolean preserveAfterCreation)
	{
		Compound compound = Compound.instance;
		NBTTagCompound tag = new NBTTagCompound();
		
		int elementPos = 0; //The number of different elements into the list the current one is
		int elementQuantity = 0; //The number of times the current element has occurred in a row
		for(int i = 0; i < elements.size(); i++)
		{
			Element element = elements.get(i);
			
			if(i > 0 && elements.get(i-1).getAtomicNumber() != element.getAtomicNumber())
			{
				elementPos++;
				elementQuantity = 1;
			}
			else elementQuantity++;
			
			tag.setIntArray(Integer.toString(elementPos), new int[]{element.getAtomicNumber(), elementQuantity});
		}
		
		ItemStack stack = new ItemStack(compound);
		
		Chemistry.networkWrapper.sendToServer(new CompoundCreate(stack, tag));
		
		if(!preserveAfterCreation) this.clearElements();
		
		return stack;
	}
	
	/**
	 * Add the given element to the buffer
	 * @param element The element to add
	 */
	public void putElement(Element element)
	{
		this.elements.add(element);
	}
	
	/**
	 * Add the given element to the buffer
	 * @param element The element to add
	 * @param quantity The number of times to add the element
	 */
	public void putElement(Element element, int quantity)
	{
		for(int i = 0; i < quantity; i++) this.putElement(element);
	}
	
	/**
	 * Add the given list of elements to the buffer
	 * @param elements The list of elements to add
	 */
	public void putElements(List<Element> elements)
	{
		for(Element element : elements) this.putElement(element);
	}
	
	/**
	 * Add the given list of elements to the buffer
	 * @param elements The list of elements to add
	 * @param quantity The number of times to add the element
	 */
	public void putElements(List<Element> elements, int quantity)
	{
		for(int i = 0; i < quantity; i++)
		{
			this.putElements(elements);
			this.putElement(Elements.getElement(EnumElement.MOLECULE_MARKER)); //Add a molecule marker after each so it's factorised
		}
		this.elements.remove(this.elements.size()-1); //Remove trailing molecule marker
	}
	
	/**
	 * Return a list of the elements in the buffer
	 * @return The elements currently in the buffer
	 */
	public List<Element> getElements()
	{
		return this.elements;
	}
	
	/**
	 * Clear all elements from the buffer
	 */
	public void clearElements()
	{
		this.elements.clear();
	}
}
