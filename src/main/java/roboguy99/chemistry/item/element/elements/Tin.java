package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Tin extends ItemElement
{
	@Override
	public String giveName()
	{
		return "tin";
	}

	@Override
	public String giveSymbol()
	{
		return "Sn";
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 50;
	}

	@Override
	public int giveAtomicMass()
	{
		return 119;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 232;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2603;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,4};
	}
	
}
