package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

/**
 * The boiling point of arsenic is lower than its melting point.
 * @author Roboguy99
 *
 */
public class Arsenic extends ItemElement
{
	@Override
	public String giveName()
	{
		return "arsenic";
	}

	@Override
	public String giveSymbol()
	{
		return "As";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 33;
	}

	@Override
	public int giveAtomicMass()
	{
		return 75;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 817;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 614;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,5};
	}
	
}
