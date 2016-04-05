package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Erbium extends Element
{
	@Override
	public String giveName()
	{
		return "erbium";
	}

	@Override
	public String giveSymbol()
	{
		return "Er";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 68;
	}

	@Override
	public int giveAtomicMass()
	{
		return 167;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1529;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2867;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 30, 8, 2};
	}
	
}
