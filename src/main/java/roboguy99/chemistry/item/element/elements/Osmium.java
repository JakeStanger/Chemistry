package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Osmium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "osmium";
	}

	@Override
	public String giveSymbol()
	{
		return "Os";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 76;
	}

	@Override
	public int giveAtomicMass()
	{
		return 190;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 3027;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 5027;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 14, 2};
	}
	
}
