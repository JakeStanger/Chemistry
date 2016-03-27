package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Boron extends Element
{
	@Override
	public String giveName()
	{
		return "boron";
	}
	
	@Override
	public String giveSymbol()
	{
		return "B";
	}
	
	@Override
	public String giveDesc()
	{
		return null;
	}
	
	@Override
	public int giveAtomicNumber()
	{
		return 5;
	}
	
	@Override
	public int giveAtomicMass()
	{
		return 11;
	}
	
	@Override
	public int giveMeltingPoint()
	{
		return 2076;
	}
	
	@Override
	public int giveBoilingPoint()
	{
		return 3927;
	}
	
	@Override
	public int[] giveElectronConfiguration()
	{
		int[] config = {2, 3};
		return config;
	}
}
