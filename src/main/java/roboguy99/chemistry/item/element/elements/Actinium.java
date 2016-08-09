package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Actinium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 11405520;
	}

	@Override
	public String giveName()
	{
		return "actinium";
	}

	@Override
	public String giveSymbol()
	{
		return "Ac";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 89;
	}

	@Override
	public int giveAtomicMass()
	{
		return 227;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1050;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3197;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 18, 9, 2};
	}
}
