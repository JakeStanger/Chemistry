package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Zirconium extends Element
{
	@Override
	public String giveName()
	{
		return "zirconium";
	}

	@Override
	public String giveSymbol()
	{
		return "Zr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 40;
	}

	@Override
	public int giveAtomicMass()
	{
		return 91;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1855;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4409;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,10,2};
	}
	
}
