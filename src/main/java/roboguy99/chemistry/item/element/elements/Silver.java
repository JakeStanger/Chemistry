package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Silver extends ItemElement
{
	@Override
	public String giveName()
	{
		return "silver";
	}

	@Override
	public String giveSymbol()
	{
		return "Ag";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 47;
	}

	@Override
	public int giveAtomicMass()
	{
		return 108;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 962;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2162;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,1};
	}
	
}
