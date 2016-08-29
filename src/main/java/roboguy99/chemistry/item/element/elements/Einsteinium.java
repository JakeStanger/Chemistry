package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

/**
 * The boiling point of Einsteinium is unknown.
 * @author Jake Stanger
 *
 */
public class Einsteinium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 397080;
	}

	@Override
	public String giveName()
	{
		return "einsteinium";
	}

	@Override
	public String giveSymbol()
	{
		return "Es";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 99;
	}

	@Override
	public int giveAtomicMass()
	{
		return 254;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 860;
	}

	@Override
	public int giveBoilingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 29, 8, 2};
	}
}
