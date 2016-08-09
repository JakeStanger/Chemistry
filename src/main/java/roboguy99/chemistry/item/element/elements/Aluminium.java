package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Aluminium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "aluminium";
	}

	@Override
	public String giveSymbol()
	{
		return "Al";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 13;
	}

	@Override
	public int giveAtomicMass()
	{
		return 27;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 660;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2519;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,3};
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}
	
}
