package roboguy99.chemistry.item.element.elements.special;

import roboguy99.chemistry.item.element.Element;

public abstract class ElementRadioactive extends Element
{
	private long halfLife;
	
	public ElementRadioactive()
	{
		this.halfLife = this.giveHalfLife();
	}	
	
	public long getHalfLife()
	{
		return this.halfLife;
	}
	
	/**
	 * The half-life of the element, in minutes
	 * @return
	 */
	public abstract long giveHalfLife();
}
