package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Terbium extends Element
{
	@Override
	public String giveName()
	{
		return "terbium";
	}

	@Override
	public String giveSymbol()
	{
		return "Tb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 65;
	}

	@Override
	public int giveAtomicMass()
	{
		return 159;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1356;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3227;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 27, 8, 2};
	}
	
}
