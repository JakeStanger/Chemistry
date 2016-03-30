package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Rutherfordium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 78;
	}

	@Override
	public String giveName()
	{
		return "rutherfordium";
	}

	@Override
	public String giveSymbol()
	{
		return "Rf";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 104;
	}

	@Override
	public int giveAtomicMass()
	{
		return 267;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2100;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 5500;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 32, 10, 2};
	}
}
