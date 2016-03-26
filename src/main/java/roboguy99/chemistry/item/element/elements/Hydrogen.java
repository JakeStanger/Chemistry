package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Hydrogen extends Element
{
	@Override
	public String giveName()
	{
		return "hydrogen";
	}

	@Override
	public String giveSymbol()
	{
		return "H";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 1;
	}

	@Override
	public int giveAtomicMass()
	{
		return 1;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -259;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -252;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		int[] config = {1};
		return config;
	}
}
