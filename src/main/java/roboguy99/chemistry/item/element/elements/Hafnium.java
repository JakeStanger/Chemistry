package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Hafnium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "hafnium";
	}

	@Override
	public String giveSymbol()
	{
		return "Hf";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 72;
	}

	@Override
	public int giveAtomicMass()
	{
		return 178;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2231;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4602;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 10, 2};
	}
	
}
