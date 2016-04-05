package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Praseodymium extends Element
{
	@Override
	public String giveName()
	{
		return "praseodymium";
	}

	@Override
	public String giveSymbol()
	{
		return "Pr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 59;
	}

	@Override
	public int giveAtomicMass()
	{
		return 141;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 931;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3512;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 21, 8, 2};
	}
	
}
