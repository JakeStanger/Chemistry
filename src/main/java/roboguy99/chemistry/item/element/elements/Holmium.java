package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Holmium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "holmium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ho";
	}

	@Override
	public Group giveGroup()
	{
		return Group.LANTHANOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 67;
	}

	@Override
	public int giveAtomicMass()
	{
		return 165;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1474;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 6695;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 29, 8, 2};
	}
	
}
