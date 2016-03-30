package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Bismuth extends Element
{
	@Override
	public String giveName()
	{
		return "bismuth";
	}

	@Override
	public String giveSymbol()
	{
		return "Bi";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 83;
	}

	@Override
	public int giveAtomicMass()
	{
		return 209;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 271;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1564;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 5};
	}
}