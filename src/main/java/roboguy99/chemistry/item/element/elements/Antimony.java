package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Antimony extends ItemElement
{
	@Override
	public String giveName()
	{
		return "antimony";
	}

	@Override
	public String giveSymbol()
	{
		return "Sb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.METALLOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 51;
	}

	@Override
	public int giveAtomicMass()
	{
		return 122;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 631;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1587;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,5};
	}
	
}
