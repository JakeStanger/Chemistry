package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Platinum extends Element
{
	@Override
	public String giveName()
	{
		return "platinum";
	}

	@Override
	public String giveSymbol()
	{
		return "Pt";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 78;
	}

	@Override
	public int giveAtomicMass()
	{
		return 195;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1768;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3825;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 17, 1};
	}
	
}