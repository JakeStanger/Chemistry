package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Xenon extends Element
{
	@Override
	public String giveName()
	{
		return "xenon";
	}

	@Override
	public String giveSymbol()
	{
		return "Xe";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASES;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 54;
	}

	@Override
	public int giveAtomicMass()
	{
		return 131;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -112;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -108;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,8};
	}
}
