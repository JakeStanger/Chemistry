package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Thorium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 7384680000000000L * 60;
	}

	@Override
	public String giveName()
	{
		return "thorium";
	}

	@Override
	public String giveSymbol()
	{
		return "Th";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 90;
	}

	@Override
	public int giveAtomicMass()
	{
		return 232;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1755;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4787;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 10, 2};
	}
	
}
