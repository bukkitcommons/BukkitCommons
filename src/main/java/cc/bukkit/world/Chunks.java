package cc.bukkit.world;

import org.bukkit.Location;

public class Chunks {
	/**
	 * Returns true if the given location is loaded or not.
	 * 
	 * @param loc
	 *            The location
	 * @return true if the given location is loaded or not.
	 */
	public static boolean isLoaded(Location loc) {
		if (loc.getWorld() == null) {
			return false;
		}
		// Calculate the chunks coordinates. These are 1,2,3 for each chunk, NOT
		// location rounded to the nearest 16.
		int x = (int) Math.floor((loc.getBlockX()) / 16.0);
		int z = (int) Math.floor((loc.getBlockZ()) / 16.0);
		if (loc.getWorld().isChunkLoaded(x, z)) {
			return true;
		} else {
			return false;
		}
	}
}
