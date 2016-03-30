package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Technetium extends ElementRadioactive
{
	@Override
	public String giveName()
	{
		return "technetium";
	}

	@Override
	public String giveSymbol()
	{
		return "Tc";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 43;
	}

	@Override
	public int giveAtomicMass()
	{
		return 99;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2204;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4265;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,13,2};
	}

	@Override
	public long giveHalfLife()
	{
		return 110901600000L;
	}
	
}
