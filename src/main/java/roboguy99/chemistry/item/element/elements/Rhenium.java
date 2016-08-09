package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Rhenium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "rhenium";
	}

	@Override
	public String giveSymbol()
	{
		return "Re";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 75;
	}

	@Override
	public int giveAtomicMass()
	{
		return 186;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 3182;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 5597;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 13, 2};
	}
	
}
