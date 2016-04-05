package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Radium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 2242560000L;
	}

	@Override
	public String giveName()
	{
		return "radium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ra";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALINE_EARTH_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 88;
	}

	@Override
	public int giveAtomicMass()
	{
		return 226;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 700;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1140;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 8, 2};
	}
}
