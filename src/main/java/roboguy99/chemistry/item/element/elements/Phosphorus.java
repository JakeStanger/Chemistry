package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Phosphorus extends Element
{
	@Override
	public String giveName()
	{
		return "phosphorus";
	}

	@Override
	public String giveSymbol()
	{
		return "P";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 15;
	}

	@Override
	public int giveAtomicMass()
	{
		return 31;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 44;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 281;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,5};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}
	
}
