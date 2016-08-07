package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Mercury extends ItemElement
{
	@Override
	public String giveName()
	{
		return "mercury";
	}

	@Override
	public String giveSymbol()
	{
		return "Hg";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 80;
	}

	@Override
	public int giveAtomicMass()
	{
		return 201;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -39;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 358;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 2};
	}
	
}
