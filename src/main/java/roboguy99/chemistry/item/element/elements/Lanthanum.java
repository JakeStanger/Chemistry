package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Lanthanum extends ItemElement
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
		return Group.LANTHANOIDS;
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
