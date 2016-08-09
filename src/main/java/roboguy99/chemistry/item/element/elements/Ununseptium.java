package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Ununseptium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1;
	}

	@Override
	public String giveName()
	{
		return "ununseptium";
	}

	@Override
	public String giveSymbol()
	{
		return "Uus";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 117;
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
		return new int[]{2, 8, 18, 32, 32, 18, 7};
	}
}
