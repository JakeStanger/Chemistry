package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Thallium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "thallium";
	}

	@Override
	public String giveSymbol()
	{
		return "Tl";
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 81;
	}

	@Override
	public int giveAtomicMass()
	{
		return 204;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 304;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1473;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 3};
	}
}
