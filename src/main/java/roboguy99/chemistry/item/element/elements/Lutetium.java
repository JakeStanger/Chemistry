package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Lutetium extends Element
{
	@Override
	public String giveName()
	{
		return "lutetium";
	}

	@Override
	public String giveSymbol()
	{
		return "Lu";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 71;
	}

	@Override
	public int giveAtomicMass()
	{
		return 175;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1663;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3395;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 9, 2};
	}
	
}