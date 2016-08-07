package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Cadmium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "cadmium";
	}

	@Override
	public String giveSymbol()
	{
		return "Cd";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 48;
	}

	@Override
	public int giveAtomicMass()
	{
		return 112;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 321;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 767;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,2};
	}
	
}
