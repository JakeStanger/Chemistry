package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Helium extends Element
{
	@Override
	public String giveName() 
	{
		return "helium";
	}

	@Override
	public String giveSymbol() 
	{
		return "He";
	}

	@Override
	public int giveAtomicNumber() 
	{
		return 2;
	}

	@Override
	public int giveAtomicMass() 
	{
		return 4;
	}

	@Override
	public int giveMeltingPoint() 
	{
		return -272;
	}

	@Override
	public int giveBoilingPoint() 
	{
		return -267;
	}

	@Override
	public int[] giveElectronConfiguration() 
	{
		return new int[]{2};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASES;
	}
}
