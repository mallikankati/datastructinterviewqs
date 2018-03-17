package ds.arrays;

/**
 * Tracking and returning stats for last N minutes
 * 
 * Ex: return last 5 minutes or one hour web traffic
 * 
 * @author mallik
 * 
 */
public class LastNMinutes {

	private int[] times;
	private int[] hits;
	// default tracking for a minute which is 60 seconds
	private int granularity = 60;

	public LastNMinutes(int seconds) {
		times = new int[seconds];
		hits = new int[seconds];
		this.granularity = seconds;
	}

	/**
	 * 
	 * @param timestamp
	 *            - The current timestamp in seconds
	 */
	public void storeHits(int timestamp) {
		int index = timestamp % granularity;
		if (times[index] != timestamp) {
			times[index] = timestamp;
			hits[index] = 1;
		} else {
			hits[index] = hits[index]++;
		}
	}

	// accept parameters in seconds in case lower granularity
	public int getHits() {
		int total = 0;
		int currentTimeSeconds = (int) System.currentTimeMillis() / 1000;
		for (int i = 0; i < granularity; i++) {
			if ((currentTimeSeconds - times[i]) < granularity) {
				total += hits[i];
			}
		}
		return total;
	}
}
