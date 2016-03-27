package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Nitrogen extends Element
{
	@Override
	public String giveName()
	{
		return "nitrogen";
	}
	
	@Override
	public String giveSymbol()
	{
		return "N";
	}
	
	@Override
	public String giveDesc()
	{
		return null;
	}
	
	@Override
	public int giveAtomicNumber()
	{
		return 7;
	}
	
	@Override
	public int giveAtomicMass()
	{
		return 14;
	}
	
	@Override
	public int giveMeltingPoint()
	{
		return -210;
	}
	
	@Override
	public int giveBoilingPoint()
	{
		return -196;
	}
	
	@Override
	public int[] giveElectronConfiguration()
	{
		int[] config = {2, 5};
		return config;
	}
}
