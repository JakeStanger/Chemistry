package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

/**
 * The melting and boiling points of Dubnium are unknown
 * @author Roboguy99
 *
 */
public class Dubnium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1740;
	}

	@Override
	public String giveName()
	{
		return "dubnium";
	}

	@Override
	public String giveSymbol()
	{
		return "Db";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 105;
	}

	@Override
	public int giveAtomicMass()
	{
		return 268;
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
		return new int[]{2, 8, 18, 32, 32, 11, 2};
	}
}
