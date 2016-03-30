package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Francium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 22;
	}

	@Override
	public String giveName()
	{
		return "francium";
	}

	@Override
	public String giveSymbol()
	{
		return "Fr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALI_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 87;
	}

	@Override
	public int giveAtomicMass()
	{
		return 223;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 27;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 677;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 8, 1};
	}
}
