package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Cobalt extends Element
{
	@Override
	public String giveName()
	{
		return "cobalt";
	}

	@Override
	public String giveSymbol()
	{
		return "Co";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 27;
	}

	@Override
	public int giveAtomicMass()
	{
		return 59;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1495;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2870;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,15,2};
	}
	
}
