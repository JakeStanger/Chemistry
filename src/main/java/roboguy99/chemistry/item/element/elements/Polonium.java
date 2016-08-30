package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Polonium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 65700000L * 60;
	}

	@Override
	public String giveName()
	{
		return "polonium";
	}

	@Override
	public String giveSymbol()
	{
		return "Po";
	}

	@Override
	public Group giveGroup()
	{
		return Group.METALLOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 84;
	}

	@Override
	public int giveAtomicMass()
	{
		return 209;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 254;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 962;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 6};
	}
}
