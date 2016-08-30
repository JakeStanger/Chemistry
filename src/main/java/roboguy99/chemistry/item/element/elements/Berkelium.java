package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Berkelium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 726642000L * 60;
	}

	@Override
	public String giveName()
	{
		return "berkelium";
	}

	@Override
	public String giveSymbol()
	{
		return "Bk";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 97;
	}

	@Override
	public int giveAtomicMass()
	{
		return 247;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 985;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 710;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 27, 8, 2};
	}
	
}
