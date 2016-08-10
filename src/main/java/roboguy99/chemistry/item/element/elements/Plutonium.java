package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Plutonium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 12672216000L;
	}

	@Override
	public String giveName()
	{
		return "plutonium";
	}

	@Override
	public String giveSymbol()
	{
		return "Pu";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 94;
	}

	@Override
	public int giveAtomicMass()
	{
		return 244;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 239;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3232;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 24, 8, 2};
	}
}
