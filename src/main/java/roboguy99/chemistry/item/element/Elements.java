package roboguy99.chemistry.item.element;

import roboguy99.chemistry.item.element.elements.Helium;
import roboguy99.chemistry.item.element.elements.Hydrogen;
import roboguy99.chemistry.item.element.elements.Oxygen;

public class Elements 
{
	public static Hydrogen hydrogen;
	public static Helium helium;
	public static Oxygen oxygen;
	
	public Elements()
	{
		hydrogen = new Hydrogen();
		helium = new Helium();
		oxygen = new Oxygen();
		
	}
}
