package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Neon extends ItemElement
{
	@Override
	public String giveName()
	{
		return "neon";
	}

	@Override
	public String giveSymbol()
	{
		return "Ne";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 10;
	}

	@Override
	public int giveAtomicMass()
	{
		return 20;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -246;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -249;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASES;
	}
	
}
