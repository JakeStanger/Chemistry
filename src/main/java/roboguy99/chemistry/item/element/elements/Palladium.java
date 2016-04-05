package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Palladium extends Element
{
	@Override
	public String giveName()
	{
		return "palladium";
	}

	@Override
	public String giveSymbol()
	{
		return "Pa";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 46;
	}

	@Override
	public int giveAtomicMass()
	{
		return 106;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1555;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2963;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18};
	}
	
}
