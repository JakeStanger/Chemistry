package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Oxygen extends Element
{
	@Override
	public String giveName()
	{
		return "oxygen";
	}

	@Override
	public String giveSymbol()
	{
		return "O";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 8;
	}

	@Override
	public int giveAtomicMass()
	{
		return 16;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -219;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 183;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		int[] config = {2, 6};
		return config;
	}

	
}
