package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

/**
 * The boiling point of Mendelevium is unknown
 * @author Roboguy99
 *
 */
public class Mendelevium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 73440;
	}

	@Override
	public String giveName()
	{
		return "mendelevium";
	}

	@Override
	public String giveSymbol()
	{
		return "Md";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 101;
	}

	@Override
	public int giveAtomicMass()
	{
		return 258;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 827;
	}

	@Override
	public int giveBoilingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 31, 8, 2};
	}
}
