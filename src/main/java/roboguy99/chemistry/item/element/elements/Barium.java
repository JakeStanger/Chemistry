package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Barium extends Element
{
	@Override
	public String giveName()
	{
		return "barium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ba";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALINE_EARTH_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 56;
	}

	@Override
	public int giveAtomicMass()
	{
		return 137;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 727;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1897;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 18, 8, 2};
	}
	
}
