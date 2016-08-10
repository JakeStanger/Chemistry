package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Germanium extends ItemElement
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
		return Group.METALLOIDS;
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
