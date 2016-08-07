package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Gadolinium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "gadolinium";
	}

	@Override
	public String giveSymbol()
	{
		return "Gd";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 64;
	}

	@Override
	public int giveAtomicMass()
	{
		return 157;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1312;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3272;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[] {2, 8, 18, 25, 9, 2};
	}
	
}
