package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Oxygen extends Element
{

private static final String NAME = "element.oxygen";
	
	private static final String SYMBOL = "O";
	
	private static final int ATOMIC_NUMBER = 8;
	private static final int ATOMIC_MASS = 16;
	
	private static final int MELTING_POINT = -219;
	private static final int BOILING_POINT = -183;
	
	private static final int[] ELECTRON_CONFIG = {2, 6};
	
	public Oxygen() 
	{
		super(NAME, SYMBOL, ATOMIC_NUMBER, ATOMIC_MASS, MELTING_POINT, BOILING_POINT, ELECTRON_CONFIG);
	}
}
