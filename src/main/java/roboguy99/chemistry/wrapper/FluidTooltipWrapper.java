package roboguy99.chemistry.wrapper;

/**
 * @author Jake stanger
 * A wrapper class for a fluid tooltip.
 */
public class FluidTooltipWrapper
{
	private int x;
	private int y;
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	private int width;
	private int height;
	
	private int fluidAmount, fluidCapacity;
	
	public int getFluidAmount()
	{
		return fluidAmount;
	}
	
	public void setFluidAmount(int fluidAmount)
	{
		this.fluidAmount = fluidAmount;
	}
	
	public int getFluidCapacity()
	{
		return fluidCapacity;
	}
	
	public void setFluidCapacity(int fluidCapacity)
	{
		this.fluidCapacity = fluidCapacity;
	}
	
	public FluidTooltipWrapper(int x, int y, int width, int height, int fluidAmount, int fluidCapacity)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fluidAmount = fluidAmount;
		this.fluidCapacity = fluidCapacity;
	}
}
