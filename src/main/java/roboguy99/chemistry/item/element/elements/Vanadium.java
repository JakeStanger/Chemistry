package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Vanadium extends Element
{
	@Override
	public String giveName()
	{
		return "vanadium";
	}

	@Override
	public String giveSymbol()
	{
		return "V";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 23;
	}

	@Override
	public int giveAtomicMass()
	{
		return 51;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1910;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3407;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,11,2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}
	
}
