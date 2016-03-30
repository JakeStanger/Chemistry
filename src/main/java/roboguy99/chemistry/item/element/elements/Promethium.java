package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Promethium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 9303120;
	}

	@Override
	public String giveName()
	{
		return "promethium";
	}

	@Override
	public String giveSymbol()
	{
		return "Pr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 61;
	}

	@Override
	public int giveAtomicMass()
	{
		return 145;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1042;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3000;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 23, 8, 2};
	}
}
