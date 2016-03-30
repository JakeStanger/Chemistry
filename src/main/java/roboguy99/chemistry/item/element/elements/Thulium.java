package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Thulium extends Element
{
	@Override
	public String giveName()
	{
		return "thulium";
	}

	@Override
	public String giveSymbol()
	{
		return "Tm";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 69;
	}

	@Override
	public int giveAtomicMass()
	{
		return 169;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1545;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1730;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 31, 8, 2};
	}
	
}
