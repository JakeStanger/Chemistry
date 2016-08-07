package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Sodium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "sodium";
	}

	@Override
	public String giveSymbol()
	{
		return "Na";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 11;
	}

	@Override
	public int giveAtomicMass()
	{
		return 23;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 98;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 883;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,1};
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALI_METALS;
	}
	
}
