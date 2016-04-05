package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

/**
 * The boiling point of Lawrencium is unknown
 * The electron configuration of Lawrencium is predicted
 * @author Roboguy99
 *
 */
public class Lawrencium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 216;
	}

	@Override
	public String giveName()
	{
		return "lawrencium";
	}

	@Override
	public String giveSymbol()
	{
		return "Lr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 103;
	}

	@Override
	public int giveAtomicMass()
	{
		return 262;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1627;
	}

	@Override
	public int giveBoilingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 32, 8, 3};
	}
}
