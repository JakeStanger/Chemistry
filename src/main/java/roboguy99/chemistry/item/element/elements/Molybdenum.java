package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Molybdenum extends ItemElement
{
	@Override
	public String giveName()
	{
		return "molybdenum";
	}

	@Override
	public String giveSymbol()
	{
		return "Mo";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 42;
	}

	@Override
	public int giveAtomicMass()
	{
		return 96;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2623;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4639;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,13,1};
	}
	
}
