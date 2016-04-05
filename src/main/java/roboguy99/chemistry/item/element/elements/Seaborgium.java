package roboguy99.chemistry.item.element.elements;

import java.awt.Color;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Seaborgium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 3;
	}

	@Override
	public String giveName()
	{
		return "seaborgium";
	}

	@Override
	public String giveSymbol()
	{
		return "Sg";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 106;
	}

	@Override
	public int giveAtomicMass()
	{
		return 269;
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
		return new int[]{2, 8, 18, 32, 32, 12, 2};
	}
}
