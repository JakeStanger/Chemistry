package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Curium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 8225640000000L;
	}

	@Override
	public String giveName()
	{
		return "curium";
	}

	@Override
	public String giveSymbol()
	{
		return "Cm";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 96;
	}

	@Override
	public int giveAtomicMass()
	{
		return 247;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1347;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3110;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 25, 9, 2};
	}
	
}
