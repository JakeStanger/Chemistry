package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Neon extends Element
{
	@Override
	public String giveName()
	{
		return "neon";
	}

	@Override
	public String giveSymbol()
	{
		return "Ne";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 10;
	}

	@Override
	public int giveAtomicMass()
	{
		return 20;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -246;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -249;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8};
	}
	
}