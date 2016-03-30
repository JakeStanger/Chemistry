package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Germanium extends Element
{
	@Override
	public String giveName()
	{
		return "germanium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ge";
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 32;
	}

	@Override
	public int giveAtomicMass()
	{
		return 74;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 938;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2883;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,4};
	}
	
}
