package roboguy99.chemistry.api;

/**
 * Handles element groups and group colours.
 * TODO Change elements to new groups TODO Generate textures for new groups
 * @author Roboguy99
 *
 */
public enum Group
{
	ALKALI_METALS("alkaliMetals"),
	ALKALINE_EARTH_METALS("alkalineEarthMetals"),
	TRANSITION_METALS("transitionMetals"),
	POST_TRANSITION_METALS("postTransitionMetals"),
	LANTHANOIDS("lanthanoids"),
	ACTINOIDS("actinoids"),
	METALLOIDS("metalloids"),
	NON_METALS("nonMetals"),
	HALOGENS("halogens"),
	NOBLE_GASES("nobleGases"),
	SPECIAL("special");
	
	public static Group[] GROUPS = new Group[]{ALKALI_METALS, ALKALINE_EARTH_METALS, TRANSITION_METALS, POST_TRANSITION_METALS, LANTHANOIDS, ACTINOIDS, METALLOIDS, NON_METALS, HALOGENS, NOBLE_GASES, SPECIAL};
	
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
				groupColour = Colour.ORANGE;
				break;
			case ALKALINE_EARTH_METALS:
				groupColour = Colour.YELLOW;
				break;
			case TRANSITION_METALS:
				groupColour = Colour.AQUA;
				break;
			case POST_TRANSITION_METALS:
				groupColour = Colour.DARK_AQUA;
				break;
			case LANTHANOIDS:
				groupColour = Colour.DARK_GREEN;
				break;
			case ACTINOIDS:
				groupColour = Colour.PINK;
				break;
			case METALLOIDS:
				groupColour = Colour.DARK_BLUE;
				break;
			case NON_METALS:
				groupColour = Colour.BRIGHT_GREEN;
				break;
			case NOBLE_GASES:
				groupColour = Colour.DARK_AQUA;
				break;
			case HALOGENS:
				groupColour = Colour.PURPLE;
				break;
			default:
				groupColour = Colour.WHITE;
				break;
		}
		
		return groupColour;
	}
}
