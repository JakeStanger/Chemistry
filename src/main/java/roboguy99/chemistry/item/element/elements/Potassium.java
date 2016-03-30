package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Potassium extends Element
{
	@Override
	public String giveName()
	{
		return "potassium";
	}

	@Override
	public String giveSymbol()
	{
		return "K";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 19;
	}

	@Override
	public int giveAtomicMass()
	{
		return 39;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 63;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 759;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,1};
	}
	
}
