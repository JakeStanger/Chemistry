package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Nickel extends Element
{
	@Override
	public String giveName()
	{
		return "nickel";
	}

	@Override
	public String giveSymbol()
	{
		return "Ni";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 28;
	}

	@Override
	public int giveAtomicMass()
	{
		return 59;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1455;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2913;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,16,2};
	}
	
}
