package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Ruthenium extends Element
{
	@Override
	public String giveName()
	{
		return "ruthenium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ru";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 44;
	}

	@Override
	public int giveAtomicMass()
	{
		return 101;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2334;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4150;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,15,1};
	}
	
}
