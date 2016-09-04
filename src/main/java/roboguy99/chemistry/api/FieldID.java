package roboguy99.chemistry.api;

/**
 * @author Jake stanger
 * IDs for TileEntity getField() methods.
 */
public enum FieldID
{
	PROCESS_TIME_REMAINING(0),
	TICK_RATE(1),
	ENERGY_STORED(2),
	TOTAL_ENERGY(3);
	
	public static FieldID[] FIELD_ID = new FieldID[]{PROCESS_TIME_REMAINING, TICK_RATE,ENERGY_STORED,TOTAL_ENERGY};
	
	public final int fieldID;
	
	FieldID(int fieldID)
	{
		this.fieldID = fieldID;
	}
}
