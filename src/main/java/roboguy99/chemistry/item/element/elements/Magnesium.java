package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Magnesium extends Element
{
	@Override
	public String giveName()
	{
		return "magnesium";
	}

	@Override
	public String giveSymbol()
	{
		return "Mg";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 12;
	}

	@Override
	public int giveAtomicMass()
	{
		return 24;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 650;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1091;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALINE_EARTH_METALS;
	}
	
}
