package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Chlorine extends Element
{
	@Override
	public String giveName()
	{
		return "chlorine";
	}

	@Override
	public String giveSymbol()
	{
		return "Cl";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 17;
	}

	@Override
	public int giveAtomicMass()
	{
		return 35;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -101;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -34;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,7};
	}
	
}
