package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Lead extends Element
{
	@Override
	public String giveName()
	{
		return "lead";
	}

	@Override
	public String giveSymbol()
	{
		return "Pb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.OTHER_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 82;
	}

	@Override
	public int giveAtomicMass()
	{
		return 207;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 328;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1749;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 4};
	}
	
}
