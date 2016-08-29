package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

/**
 * The boiling point of Fermium is unknown
 * @author Jake Stanger
 *
 */
public class Fermium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 144720;
	}

	@Override
	public String giveName()
	{
		return "fermium";
	}

	@Override
	public String giveSymbol()
	{
		return "Fm";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 100;
	}

	@Override
	public int giveAtomicMass()
	{
		return 257;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1527;
	}

	@Override
	public int giveBoilingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 30, 8, 2};
	}
}
