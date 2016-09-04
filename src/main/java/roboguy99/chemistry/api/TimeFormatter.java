package roboguy99.chemistry.api;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * Formats a time, given in seconds, to the appropriate human-readable format.
 * Written by David Wallace.
 * <a href="http://codereview.stackexchange.com/questions/139970/convert-length-of-time-to-appropriate-unit/139972">See here</a>.
 */
public class TimeFormatter {
	
	private NavigableMap<Long,String> timeUnits = new TreeMap<>();
	
	public TimeFormatter() {
		timeUnits.put(Long.MIN_VALUE, " is not a valid argument");
		timeUnits.put(TimeUnit.SECONDS.toSeconds(1), " seconds");
		timeUnits.put(TimeUnit.MINUTES.toSeconds(1), " minutes");
		timeUnits.put(TimeUnit.HOURS.toSeconds(1), " hours");
		timeUnits.put(TimeUnit.DAYS.toSeconds(1), " days");
		timeUnits.put(TimeUnit.DAYS.toSeconds(365), " years");
		timeUnits.put(TimeUnit.DAYS.toSeconds(365 * 1000000L), " million years");
		timeUnits.put(TimeUnit.DAYS.toSeconds(365 * 1000000L * 1000), " billion years");
	}
	
	public String format(long seconds) {
		Map.Entry<Long,String> unitBelow = timeUnits.floorEntry(seconds);
		
		int time = (int) (seconds / unitBelow.getKey());
		String formatted = time + unitBelow.getValue();
		
		if(time == 1 && unitBelow.getKey() < TimeUnit.DAYS.toSeconds(365 * 1000000L)) formatted = formatted.substring(0, formatted.length()-1); //Remove plural
		
		return formatted;
	}
}