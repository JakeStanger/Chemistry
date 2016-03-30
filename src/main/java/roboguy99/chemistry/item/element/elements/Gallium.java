package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Gallium extends Element
{
	@Override
	public String giveName()
	{
		return "gallium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ga";
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 31;
	}

	@Override
	public int giveAtomicMass()
	{
		return 70;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 30;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2205;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,3};
	}
	
}