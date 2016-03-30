package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Rubidium extends Element
{
	@Override
	public String giveName()
	{
		return "rubidium";
	}

	@Override
	public String giveSymbol()
	{
		return "Rb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALI_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 37;
	}

	@Override
	public int giveAtomicMass()
	{
		return 85;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 39;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 688;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,1};
	}
	
}
