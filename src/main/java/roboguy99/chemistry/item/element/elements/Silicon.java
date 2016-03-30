package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Silicon extends Element
{
	@Override
	public String giveName()
	{
		return "silicon";
	}

	@Override
	public String giveSymbol()
	{
		return "Si";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 14;
	}

	@Override
	public int giveAtomicMass()
	{
		return 28;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1414;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2357;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,4};
	}
	
}
