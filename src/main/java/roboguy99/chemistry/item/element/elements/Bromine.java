package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Bromine extends ItemElement
{
	@Override
	public String giveName()
	{
		return "bromine";
	}

	@Override
	public String giveSymbol()
	{
		return "Br";
	}

	@Override
	public Group giveGroup()
	{
		return Group.HALOGENS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 35;
	}

	@Override
	public int giveAtomicMass()
	{
		return 80;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -7;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 59;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,7};
	}
	
}
