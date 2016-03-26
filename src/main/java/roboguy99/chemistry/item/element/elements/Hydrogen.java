package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Hydrogen extends Element
{
	private static final String NAME = "element.hydrogen";
	
	private static final String SYMBOL = "H";
	
	private static final int ATOMIC_NUMBER = 1;
	private static final int ATOMIC_MASS = 1;
	
	private static final int MELTING_POINT = -259;
	private static final int BOILING_POINT = -252;
	
	private static final int[] ELECTRON_CONFIG = {1};
	
	public Hydrogen() 
	{
		super(NAME, SYMBOL, ATOMIC_NUMBER, ATOMIC_MASS, MELTING_POINT, BOILING_POINT, ELECTRON_CONFIG);
	}
}
