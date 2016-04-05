package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Gold extends Element
{
	@Override
	public String giveName()
	{
		return "gold";
	}

	@Override
	public String giveSymbol()
	{
		return "Au";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 79;
	}

	@Override
	public int giveAtomicMass()
	{
		return 197;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1064;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2970;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 1};
	}
	
}
