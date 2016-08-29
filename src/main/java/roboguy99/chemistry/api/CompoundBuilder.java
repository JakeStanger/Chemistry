package roboguy99.chemistry.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements.Element;
import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.item.element.elements.special.ElementSpecial;
import roboguy99.chemistry.network.packet.CompoundCreate;

/**
 * Creates compounds from given elements.
 * The elements given are stored in a buffer until the buffer is wiped.
 * @author Jake Stanger
 */
public class CompoundBuilder
{
	private List<ItemElement> elements = new ArrayList<ItemElement>();
	
	/**
	 * Creates a compound from the elements put into the elements list.<br>
	 * Factorising is supported, however you cannot factorise a factorised compound.
	 * This means adding a factorised molecule more than once will not factorise it a second time, 
	 * but instead will have strange and unwanted effects.<br>
	 * In other words, you can't have brackets inside brackets.
	 * @param preserveAfterCreation Should the buffer be reset after creation?
	 * @return an itemstack for the compound
	 */
	public ItemStack createCompound(boolean preserveAfterCreation) throws NullPointerException
	{
		Compound compound = Compound.instance;
		NBTTagCompound tag = new NBTTagCompound();
		
		int elementPos = 0; //The number of different elements into the list the current one is
		int elementQuantity = 0; //The number of times the current element has occurred in a row
		for(int i = 0; i < elements.size(); i++)
		{
			ItemElement element = elements.get(i);
			
			if(i > 0 && elements.get(i-1).getAtomicNumber() != element.getAtomicNumber())
			{
				elementPos++;
				elementQuantity = 1;
			}
			else elementQuantity++;
			
			tag.setIntArray(Integer.toString(elementPos), new int[]{element.getAtomicNumber(), elementQuantity});
		}
		
		ItemStack stack = new ItemStack(compound);
		stack.setTagCompound(tag);
		
		if(!preserveAfterCreation) this.clearElements();
		
		return stack;
	}
	
	/**
	 * Add the given element to the buffer.
	 * @param element The element to add
	 */
	public void putElement(ItemElement element)
	{
		this.elements.add(element); //Add a molecule marker after each so it's factorised
	}
	
	/**
	 * Add the given element to the buffer
	 * @param element The element to add
	 * @param quantity The number of times to add the element
	 */
	public void putElement(ItemElement element, int quantity)
	{
		for(int i = 0; i < quantity; i++) this.elements.add(element);
	}
	
	/**
	 * Add the given list of elements to the buffer.
	 * @param elements The list of elements to add
	 */
	public void putElements(List<ItemElement> elements)
	{
		for(ItemElement element : elements) this.elements.add(element);
	}
	
	/**
	 * Add the given list of elements to the buffer.
	 * This will automatically add a molecule marker.
	 * @param elements The list of elements to add
	 * @param quantity The number of times to add the element
	 */
	public void putElements(List<ItemElement> elements, int quantity)
	{
		for(int i = 0; i < quantity; i++)
		{
			for(ItemElement element : elements) this.elements.add(element);
			this.endMolecule();
		}
		this.removeTrailingMoleculeMarker();
	}
	
	/**
	 * Mark the end of a molecule by adding a molecule marker element
	 */
	public void endMolecule()
	{
		this.elements.add(Element.MOLECULE_MARKER.getElement());
	}
	
	/**
	 * Return a list of the elements in the buffer
	 * @return The elements currently in the buffer
	 */
	public List<ItemElement> getElements()
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
	
	/**
	 * Remove the last element from the buffer.
	 * When this method is called, 
	 * it will always be a molecule marker.
	 */
	private void removeTrailingMoleculeMarker()
	{
		this.elements.remove(this.elements.size()-1);
	}
}
