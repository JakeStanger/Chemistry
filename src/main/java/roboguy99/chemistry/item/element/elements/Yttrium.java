package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Yttrium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "yttrium";
	}

	@Override
	public String giveSymbol()
	{
		return "Y";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 39;
	}

	@Override
	public int giveAtomicMass()
	{
		return 89;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1522;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3338;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,9,2};
	}
	
}
