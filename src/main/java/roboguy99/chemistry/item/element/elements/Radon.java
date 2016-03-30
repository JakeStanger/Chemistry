package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Radon extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 5472;
	}

	@Override
	public String giveName()
	{
		return "radon";
	}

	@Override
	public String giveSymbol()
	{
		return "Rn";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASSES;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 86;
	}

	@Override
	public int giveAtomicMass()
	{
		return 222;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -71;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -62;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 8};
	}
}
