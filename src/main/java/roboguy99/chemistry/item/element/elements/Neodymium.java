package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Neodymium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "neodymium";
	}

	@Override
	public String giveSymbol()
	{
		return "Nd";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 60;
	}

	@Override
	public int giveAtomicMass()
	{
		return 144;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1021;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3074;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 22, 8, 2};
	}
	
}
