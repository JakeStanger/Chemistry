package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Californium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 473040000;
	}

	@Override
	public String giveName()
	{
		return "californium";
	}

	@Override
	public String giveSymbol()
	{
		return "Cf";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 98;
	}

	@Override
	public int giveAtomicMass()
	{
		return 251;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 899;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1472;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 28, 8, 2};
	}
	
}
