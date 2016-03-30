package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Argon extends Element
{
	@Override
	public String giveName()
	{
		return "argon";
	}

	@Override
	public String giveSymbol()
	{
		return "Ar";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 18;
	}

	@Override
	public int giveAtomicMass()
	{
		return 40;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -189;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -186;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,8};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASES;
	}
	
}
