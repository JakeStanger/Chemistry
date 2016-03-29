package roboguy99.chemistry.item.compound;

import java.util.HashMap;

public class CompoundNames
{
	/**
	 * A map of formulas to compound names.
	 * Formulas should be structural, and without subscript
	 * (C2H5OH)
	 */
	public static HashMap<String, String> names;
	
	public CompoundNames()
	{
		names = new HashMap<String, String>();
		
		names.put("H2O", "compound.water");
		names.put("C6H2NO2NO2NO2CH3", "compound.tnt");
	}
}
