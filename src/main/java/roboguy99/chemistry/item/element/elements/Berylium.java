package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Berylium extends Element
{
	@Override
	public String giveName()
	{
		return "berylium";
	}

	@Override
	public String giveSymbol()
	{
		return "Be";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 4;
	}

	@Override
	public int giveAtomicMass()
	{
		return 9;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1287;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2970;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALINE_EARTH_METALS;
	}
}
