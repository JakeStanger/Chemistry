package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Iridium extends Element
{
	@Override
	public String giveName()
	{
		return "iridium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ir";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 77;
	}

	@Override
	public int giveAtomicMass()
	{
		return 192;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2447;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4427;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 15, 2};
	}
	
}
