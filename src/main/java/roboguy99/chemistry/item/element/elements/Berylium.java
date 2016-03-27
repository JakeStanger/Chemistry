package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

public class Berylium extends Element
{
	@Override
	public String giveName()
	{
		return "berylium";
	}

	@Override
	public String giveSymbol()
	{
		return "Be";
	}

	@Override
	public String giveDesc()
	{
		return "Beryllium is used in alloys with copper or nickel to make gyroscopes, springs, electrical contacts, spot-welding electrodes and non-sparking tools.";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 4;
	}

	@Override
	public int giveAtomicMass()
	{
		return 9;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1287;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2970;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		int[] config = {2, 2};
		return config;
	}
}
