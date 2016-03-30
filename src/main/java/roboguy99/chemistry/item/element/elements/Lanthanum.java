package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Lanthanum extends Element
{
	@Override
	public String giveName()
	{
		return "lanthanum";
	}

	@Override
	public String giveSymbol()
	{
		return "La";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 57;
	}

	@Override
	public int giveAtomicMass()
	{
		return 139;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 920;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3463;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 18, 9, 2};
	}
	
}
