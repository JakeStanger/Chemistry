package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Astatine extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 486;
	}

	@Override
	public String giveName()
	{
		return "astatine";
	}

	@Override
	public String giveSymbol()
	{
		return "At";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NON_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 85;
	}

	@Override
	public int giveAtomicMass()
	{
		return 210;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 302;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 337;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 7};
	}
	
}
