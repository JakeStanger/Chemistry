package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Uranium extends ElementRadioactive
{
	@Override
	public String giveName()
	{
		return "uranium";
	}

	@Override
	public String giveSymbol()
	{
		return "U";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 92;
	}

	@Override
	public int giveAtomicMass()
	{
		return 238;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1132;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4131;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,32,21,9,2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public long giveHalfLife()
	{
		return 2365200000000000L;
	}
}
