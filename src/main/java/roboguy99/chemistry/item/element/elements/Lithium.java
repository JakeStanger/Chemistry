package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Lithium extends Element
{
	@Override
	public String giveName()
	{
		return "lithium";
	}

	@Override
	public String giveSymbol()
	{
		return "Li";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 3;
	}

	@Override
	public int giveAtomicMass()
	{
		return 7;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 181;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1342;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		int[] config = {2, 1};
		return new int[]{2,1};
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALI_METALS;
	}
}
