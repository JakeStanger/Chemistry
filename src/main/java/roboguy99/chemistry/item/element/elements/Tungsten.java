package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Tungsten extends Element
{
	@Override
	public String giveName()
	{
		return "tungsten";
	}

	@Override
	public String giveSymbol()
	{
		return "W";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 74;
	}

	@Override
	public int giveAtomicMass()
	{
		return 184;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 3422;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 5555;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 12, 2};
	}
	
}
