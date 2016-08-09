package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Indium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "indium";
	}

	@Override
	public String giveSymbol()
	{
		return "In";
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 49;
	}

	@Override
	public int giveAtomicMass()
	{
		return 115;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 157;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2072;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,3};
	}
	
}
