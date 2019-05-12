package cc.bukkit.scheduler;

import java.util.HashMap;
import java.util.UUID;

public class CustomTimer {
	static HashMap<UUID, Long> timerMap = new HashMap<>();
	/**
	 * Create a Timer and return this timer's UUID
	 * @return
	 */
	public static UUID setTimer() {
		UUID random = UUID.randomUUID();
		timerMap.put(random, System.nanoTime());
		return random;
	}
	/**
	 * Return how long time running when timer set. THIS NOT WILL DESTORY AND STOP THE TIMER
	 * @param UUID timer's uuid
	 * @return long time(nano)
	 */
	public static long getTimer(UUID timerUUID) {
		return System.nanoTime()-timerMap.get(timerUUID);
	}
	/**
	 * Return how long time running when timer set and destory the timer.
	 * @param String logs
	 * @return long time(nano)
	 */
	public static long endTimer(UUID timerUUID) {
		long time =System.nanoTime()-timerMap.get(timerUUID);
		timerMap.remove(timerUUID);
		return time;
	}
}
