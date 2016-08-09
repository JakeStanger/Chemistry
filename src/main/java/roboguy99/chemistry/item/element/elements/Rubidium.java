package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Rubidium extends ItemElement
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
