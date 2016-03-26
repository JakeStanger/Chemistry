package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Helium extends Element
{
	private static final String NAME = "element.helium";
	
	private static final String SYMBOL = "He";
	
	private static final int ATOMIC_NUMBER = 2;
	private static final int ATOMIC_MASS = 2;
	
	private static final int MELTING_POINT = -272;
	private static final int BOILING_POINT = -267;
	
	private static final int[] ELECTRON_CONFIG = {2};
	
	public Helium() 
	{
		super(NAME, SYMBOL, ATOMIC_NUMBER, ATOMIC_MASS, MELTING_POINT, BOILING_POINT, ELECTRON_CONFIG);
	}
}
