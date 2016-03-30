package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Aluminium extends Element
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
