package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Sulphur extends Element
{
	@Override
	public String giveName()
	{
		return "sulphur";
	}

	@Override
	public String giveSymbol()
	{
		return "S";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 16;
	}

	@Override
	public int giveAtomicMass()
	{
		return 32;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 115;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 445;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,6};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}
	
}
