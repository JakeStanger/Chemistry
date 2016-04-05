package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Calcium extends Element
{
	@Override
	public String giveName()
	{
		return "calcium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ca";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 20;
	}

	@Override
	public int giveAtomicMass()
	{
		return 40;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 842;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1484;
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
