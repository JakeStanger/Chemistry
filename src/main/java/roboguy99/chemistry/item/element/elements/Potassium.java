package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Potassium extends ItemElement
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

	@Override
	public Group giveGroup()
	{
		return Group.ALKALI_METALS;
	}
	
}
