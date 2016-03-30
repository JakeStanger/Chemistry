package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Iron extends Element
{
	@Override
	public String giveName()
	{
		return "iron";
	}

	@Override
	public String giveSymbol()
	{
		return "Fe";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 26;
	}

	@Override
	public int giveAtomicMass()
	{
		return 56;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1538;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2862;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,14,2};
	}
	
}
