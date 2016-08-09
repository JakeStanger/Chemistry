package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Nitrogen extends ItemElement
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
		return new int[]{2,5};
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}
}
