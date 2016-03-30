package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Niobium extends Element
{
	@Override
	public String giveName()
	{
		return "niobium";
	}

	@Override
	public String giveSymbol()
	{
		return "Nb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 41;
	}

	@Override
	public int giveAtomicMass()
	{
		return 93;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 2469;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4927;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,12,1};
	}
	
}