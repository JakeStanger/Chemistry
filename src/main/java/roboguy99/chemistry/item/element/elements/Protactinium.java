package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Protactinium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 17218656000L;
	}

	@Override
	public String giveName()
	{
		return "protactinium";
	}

	@Override
	public String giveSymbol()
	{
		return "Pa";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 91;
	}

	@Override
	public int giveAtomicMass()
	{
		return 231;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1568;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 4027;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 20, 9, 2};
	}
	
}
