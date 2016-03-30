package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Tellurium extends Element
{
	@Override
	public String giveName()
	{
		return "tellurium";
	}

	@Override
	public String giveSymbol()
	{
		return "Te";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 52;
	}

	@Override
	public int giveAtomicMass()
	{
		return 128;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 450;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 988;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,6};
	}
	
}
