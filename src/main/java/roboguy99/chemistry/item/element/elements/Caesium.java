package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Caesium extends Element
{
	@Override
	public String giveName()
	{
		return "caesium";
	}

	@Override
	public String giveSymbol()
	{
		return "Cs";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ALKALI_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 55;
	}

	@Override
	public int giveAtomicMass()
	{
		return 133;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 28;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 671;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 18, 8, 1};
	}
	
}
