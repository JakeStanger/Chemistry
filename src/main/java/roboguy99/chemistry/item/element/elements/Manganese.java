package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Manganese extends ItemElement
{
	@Override
	public String giveName()
	{
		return "manganese";
	}

	@Override
	public String giveSymbol()
	{
		return "Mn";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 25;
	}

	@Override
	public int giveAtomicMass()
	{
		return 55;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1246;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2061;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,13,2};
	}
}
