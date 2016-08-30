package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Americium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 3873672000L * 60;
	}

	@Override
	public String giveName()
	{
		return "americium";
	}

	@Override
	public String giveSymbol()
	{
		return "Am";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 95;
	}

	@Override
	public int giveAtomicMass()
	{
		return 243;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1176;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2607;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 25, 8, 2};
	}
	
}
