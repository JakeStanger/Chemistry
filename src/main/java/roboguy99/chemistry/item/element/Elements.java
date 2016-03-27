package roboguy99.chemistry.item.element;

import java.util.LinkedHashMap;

import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.elements.Carbon;
import roboguy99.chemistry.item.element.elements.Helium;
import roboguy99.chemistry.item.element.elements.Hydrogen;
import roboguy99.chemistry.item.element.elements.Oxygen;
import roboguy99.chemistry.item.element.elements.Uranium;

public class Elements 
{
	public static Hydrogen hydrogen;
	public static Helium helium;
	public static Oxygen oxygen;
	public static Carbon carbon;
	public static Uranium uranium;
	
	public static Compound ethanol;
	
	public Elements()
	{
		hydrogen = new Hydrogen();
		helium = new Helium();
		oxygen = new Oxygen();
		carbon = new Carbon();
		uranium = new Uranium();
		
		LinkedHashMap waterCompound = new LinkedHashMap();
		waterCompound.put(Elements.hydrogen, 2);
		waterCompound.put(Elements.oxygen, 1);
		Compound water = new Compound(waterCompound);
		
		LinkedHashMap glucoseCompound = new LinkedHashMap();
		glucoseCompound.put(Elements.carbon, 6);
		glucoseCompound.put(Elements.hydrogen, 12);
		glucoseCompound.put(Elements.oxygen, 6);
		Compound glucose = new Compound(glucoseCompound);
		
		LinkedHashMap ethanolCompoundMain = new LinkedHashMap();
		ethanolCompoundMain.put(Elements.carbon, 2);
		ethanolCompoundMain.put(Elements.hydrogen, 5);
		Compound ethanolMain = new Compound(ethanolCompoundMain);
		
		LinkedHashMap ethanolCompoundFunctional = new LinkedHashMap();
		ethanolCompoundFunctional.put(Elements.oxygen, 1);
		ethanolCompoundFunctional.put(Elements.hydrogen, 1);
		Compound ethanolFunctional = new Compound(ethanolCompoundFunctional);
		
		Compound[] compoundArray = {ethanolMain, ethanolFunctional};
		ethanol = new Compound(compoundArray);
	}
}
