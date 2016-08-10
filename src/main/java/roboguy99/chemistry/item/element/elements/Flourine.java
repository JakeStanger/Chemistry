package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Flourine extends ItemElement
{
	@Override
	public String giveName()
	{
		return "flourine";
	}

	@Override
	public String giveSymbol()
	{
		return "F";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 9;
	}

	@Override
	public int giveAtomicMass()
	{
		return 19;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -220;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -188;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,7};
	}

	@Override
	public Group giveGroup()
	{
		return Group.HALOGENS;
	}
	
}
