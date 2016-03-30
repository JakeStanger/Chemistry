package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Rhodium extends Element
{
	@Override
	public String giveName()
	{
		return "rhodium";
	}

	@Override
	public String giveSymbol()
	{
		return "Rh";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 45;
	}

	@Override
	public int giveAtomicMass()
	{
		return 103;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1963;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3697;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,16,1};
	}
	
}
