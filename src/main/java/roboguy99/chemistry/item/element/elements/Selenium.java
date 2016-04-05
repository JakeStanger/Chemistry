package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Selenium extends Element
{
	@Override
	public String giveName()
	{
		return "selenium";
	}

	@Override
	public String giveSymbol()
	{
		return "Se";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 34;
	}

	@Override
	public int giveAtomicMass()
	{
		return 79;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 221;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 685;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,6};
	}
	
}
