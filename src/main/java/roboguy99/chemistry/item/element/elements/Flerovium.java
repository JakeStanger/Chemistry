package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Flerovium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1;
	}

	@Override
	public String giveName()
	{
		return "flerovium";
	}

	@Override
	public String giveSymbol()
	{
		return "Fl";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 114;
	}

	@Override
	public int giveAtomicMass()
	{
		return 289;
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
		return new int[]{2, 8, 18, 32, 32, 18, 4};
	}
}
