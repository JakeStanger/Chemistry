package roboguy99.chemistry.api;

public enum Group
{
	ALKALI_METALS("alkaliMetals"),
	ALKALINE_EARTH_METALS("alkalineEarthMetals"),
	TRANSITION_METALS("transitionMetals"),
	OTHER_METALS("otherMetals"),
	NON_METALS("nonMetals"),
	NOBLE_GASES("nobleGases"),
	SPECIAL("special");
	
	public static Group[] GROUPS = new Group[]{ALKALI_METALS, ALKALINE_EARTH_METALS, TRANSITION_METALS, OTHER_METALS, NON_METALS, NOBLE_GASES, SPECIAL};
	
	public final String groupName;
	
	private Group(String groupName)
	{
		this.groupName = "group." + groupName;
	}
	
	/**
	 * Gets the associated chat colour for the given group.
	 * @param group The group.
	 * @return The colour.
	 * @author Roboguy99
	 */
	public static Colour getGroupColour(Group group)
	{
		Colour groupColour;
		
		switch(group)
		{
			case ALKALI_METALS:
				groupColour = Colour.WHITE;
				break;
			case ALKALINE_EARTH_METALS:
				groupColour = Colour.PINK;
				break;
			case TRANSITION_METALS:
				groupColour = Colour.AQUA;
				break;
			case OTHER_METALS:
				groupColour = Colour.ORANGE;
				break;
			case NON_METALS:
				groupColour = Colour.BRIGHT_GREEN;
				break;
			case NOBLE_GASES:
				groupColour = Colour.YELLOW;
				break;
			default:
				groupColour = Colour.WHITE;
				break;
		}
		
		return groupColour;
	}
}
