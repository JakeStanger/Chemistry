package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.Element;

public class Zinc extends Element
{
	@Override
	public String giveName()
	{
		return "zinc";
	}

	@Override
	public String giveSymbol()
	{
		return "Zn";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 30;
	}

	@Override
	public int giveAtomicMass()
	{
		return 65;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 420;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 907;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,2};
	}
	
}
