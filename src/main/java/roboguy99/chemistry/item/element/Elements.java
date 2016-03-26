package roboguy99.chemistry.item.element;

import java.util.LinkedHashMap;

import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.elements.Carbon;
import roboguy99.chemistry.item.element.elements.Helium;
import roboguy99.chemistry.item.element.elements.Hydrogen;
import roboguy99.chemistry.item.element.elements.Oxygen;

public class Elements 
{
	public static Hydrogen hydrogen;
	public static Helium helium;
	public static Oxygen oxygen;
	public static Carbon carbon;
	
	public Elements()
	{
		hydrogen = new Hydrogen();
		helium = new Helium();
		oxygen = new Oxygen();
		carbon = new Carbon();
		
		LinkedHashMap waterCompound = new LinkedHashMap();
		waterCompound.put(Elements.hydrogen, 2);
		waterCompound.put(Elements.oxygen, 1);
		Compound water = new Compound(waterCompound);
	}
}
