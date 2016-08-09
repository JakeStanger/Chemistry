package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Chromium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "chromium";
	}

	@Override
	public String giveSymbol()
	{
		return "Cr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 24;
	}

	@Override
	public int giveAtomicMass()
	{
		return 52;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1907;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2672;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,13,1};
	}
}
