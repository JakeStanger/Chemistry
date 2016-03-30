package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Ununoctium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1;
	}

	@Override
	public String giveName()
	{
		return "ununoctium";
	}

	@Override
	public String giveSymbol()
	{
		return "Uuo";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASSES;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 118;
	}

	@Override
	public int giveAtomicMass()
	{
		return 294;
	}

	@Override
	public int giveMeltingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int giveBoilingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 32, 18, 8};
	}
}
