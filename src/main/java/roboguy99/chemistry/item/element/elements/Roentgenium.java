package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Roentgenium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 126;
	}

	@Override
	public String giveName()
	{
		return "roentgenium";
	}

	@Override
	public String giveSymbol()
	{
		return "Rg";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 111;
	}

	@Override
	public int giveAtomicMass()
	{
		return 282;
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
		return new int[]{2, 8, 18, 32, 32, 18, 1};
	}
}
