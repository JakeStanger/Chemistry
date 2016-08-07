package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Europium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "europium";
	}

	@Override
	public String giveSymbol()
	{
		return "Eu";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 63;
	}

	@Override
	public int giveAtomicMass()
	{
		return 152;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 826;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1529;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[] {2, 8, 18, 25, 8, 2};
	}	
}
