package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Niobium extends ItemElement
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
