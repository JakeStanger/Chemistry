package roboguy99.chemistry.api;

import java.util.HashMap;

public class CompoundNamer
{
	/**
	 * A map of formulas to compound names.
	 * Formulas should be structural, and without subscript
	 * (C2H5OH)
	 */
	private static HashMap<String, String> names;
	
	public CompoundNamer()
	{
		names = new HashMap<String, String>();
		
		//Example names
		this.putName("H2O", "water");
		this.putName("C6H2(NO2)3CH3", "tnt");
	}
	
	/**
	 * Puts the given formula and name into the map.
	 * Formulas should be as they would be displayed on screen, but without superscript.
	 * For example, water would be <i>H2O</i> or TNT would be <i>C6H2(NO2)3CH3</i>.
	 * @param formula The formula to give a name for
	 * @param unlocalisedName The unlocalised name for the formula
	 */
	public static void putName(String formula, String unlocalisedName)
	{
		names.put(formula, "compound." + unlocalisedName);
	}
	
	/**
	 * Gets the entire names map.
	 * @return The map of all formulas and their respective names.
	 */
	public static HashMap<String, String> getNames()
	{
		return names;
	}
	
	/**
	 * Gets the name for a given formula.
	 * @param formula The formula to get the name for.
	 * @return The name of the given formula.
	 */
	public static String getName(String formula)
	{
		return names.get(formula);
	}
	
	/**
	 * Checks if the given name is already in the map.
	 * @param name The unlocalised compound name to check
	 * @return True if the name is in the map.
	 */
	public static boolean isFormulaInMap(String name)
	{
		return names.containsKey(name);
	}
	
	/**
	 * Checks if the given formula is already in the map.
	 * Formulas should be as they would be displayed on screen, but without superscript.
	 * For example, water would be <i>H2O</i> or TNT would be <i>C6H2(NO2)3CH3</i>.
	 * @param formula The formula name to check
	 * @return True if the formula is in the map.
	 */
	public static boolean isNameInMap(String formula)
	{
		return names.containsValue(formula);
	}
}
