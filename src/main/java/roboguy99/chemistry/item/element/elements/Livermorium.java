package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Livermorium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1;
	}

	@Override
	public String giveName()
	{
		return "livermorium";
	}

	@Override
	public String giveSymbol()
	{
		return "Lv";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 116;
	}

	@Override
	public int giveAtomicMass()
	{
		return 293;
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
		return new int[]{2, 8, 18, 32, 32, 18, 6};
	}
}
