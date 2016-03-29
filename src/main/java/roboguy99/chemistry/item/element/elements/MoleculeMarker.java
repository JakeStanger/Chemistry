package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;

/**
 * A special element with no mass used for marking the beginning/end of a molecule
 * @author Roboguy99
 *
 */
public class MoleculeMarker extends Element
{
	@Override
	public String giveName()
	{
		return "marker.molecule";
	}

	@Override
	public String giveSymbol()
	{
		return "|";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 119;
	}

	@Override
	public int giveAtomicMass()
	{
		return 0;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 0;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 0;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{0};
	}
	
}
