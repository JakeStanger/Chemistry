package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Oxygen extends ItemElement
{
	@Override
	public String giveName()
	{
		return "oxygen";
	}

	@Override
	public String giveSymbol()
	{
		return "O";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 8;
	}

	@Override
	public int giveAtomicMass()
	{
		return 16;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -219;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 183;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,6};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}
}
