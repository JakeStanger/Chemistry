package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Carbon extends Element
{
	@Override
	public String giveName()
	{
		return "carbon";
	}

	@Override
	public String giveSymbol()
	{
		return "C";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 6;
	}

	@Override
	public int giveAtomicMass()
	{
		return 12;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 3550;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4827;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 4};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}
}
