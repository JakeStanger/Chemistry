package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Strontium extends Element
{
	@Override
	public String giveName()
	{
		return "strontium";
	}

	@Override
	public String giveSymbol()
	{
		return "Sr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALINE_EARTH_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 38;
	}

	@Override
	public int giveAtomicMass()
	{
		return 88;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 769;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1382;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,2};
	}
	
}
