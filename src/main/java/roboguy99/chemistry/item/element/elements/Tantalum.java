package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Tantalum extends ItemElement
{
	@Override
	public String giveName()
	{
		return "tantalum";
	}

	@Override
	public String giveSymbol()
	{
		return "Ta";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 73;
	}

	@Override
	public int giveAtomicMass()
	{
		return 181;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 3020;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 5457;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 11, 2};
	}
	
}
