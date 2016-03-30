package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Hassium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1;
	}

	@Override
	public String giveName()
	{
		return "hassium";
	}

	@Override
	public String giveSymbol()
	{
		return "Hs";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 108;
	}

	@Override
	public int giveAtomicMass()
	{
		return 239;
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
		return new int[]{2, 8, 18, 32, 32, 14, 2};
	}
}
