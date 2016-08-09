package roboguy99.chemistry.wrapper;

/**
 * A wrapper class for two integers.
 * Used for where a minimum and maximum value are both required.
 * @see roboguy99.chemistry.api.Ores Ore registry class
 * @author Roboguy99
 *
 */
public class MinMax
{
	private int min, max;
	
	public MinMax(int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	
	public int getMin()
	{
		return this.min;
	}
	
	public int getMax()
	{
		return this.max;
	}
}
