package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Thulium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "thulium";
	}

	@Override
	public String giveSymbol()
	{
		return "Tm";
	}

	@Override
	public Group giveGroup()
	{
		return Group.LANTHANOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 69;
	}

	@Override
	public int giveAtomicMass()
	{
		return 169;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1545;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1730;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 31, 8, 2};
	}
	
}
