package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Krypton extends ItemElement
{
	@Override
	public String giveName()
	{
		return "krypton";
	}

	@Override
	public String giveSymbol()
	{
		return "Kr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASES;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 36;
	}

	@Override
	public int giveAtomicMass()
	{
		return 84;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -157;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -153;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,8};
	}
	
}
