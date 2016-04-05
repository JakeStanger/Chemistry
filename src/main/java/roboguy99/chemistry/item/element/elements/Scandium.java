package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Scandium extends Element
{
	@Override
	public String giveName()
	{
		return "scandium";
	}

	@Override
	public String giveSymbol()
	{
		return "Sc";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 21;
	}

	@Override
	public int giveAtomicMass()
	{
		return 45;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1541;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2836;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,9,2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}
	
}
