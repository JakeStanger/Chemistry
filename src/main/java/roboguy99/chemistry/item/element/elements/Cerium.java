package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Cerium extends Element
{
	@Override
	public String giveName()
	{
		return "cerium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ce";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 58;
	}

	@Override
	public int giveAtomicMass()
	{
		return 140;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 795;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3443;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 19, 9, 2};
	}
	
}
