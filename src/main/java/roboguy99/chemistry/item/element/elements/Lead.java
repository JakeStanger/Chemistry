package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Lead extends ItemElement
{
	@Override
	public String giveName()
	{
		return "lead";
	}

	@Override
	public String giveSymbol()
	{
		return "Pb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.POST_TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 82;
	}

	@Override
	public int giveAtomicMass()
	{
		return 207;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 328;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1749;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 4};
	}
	
}
