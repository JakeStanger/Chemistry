package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Titanium extends Element
{
	@Override
	public String giveName()
	{
		return "titanium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ti";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 22;
	}

	@Override
	public int giveAtomicMass()
	{
		return 48;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1668;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3287;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,10,2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}
	
}
