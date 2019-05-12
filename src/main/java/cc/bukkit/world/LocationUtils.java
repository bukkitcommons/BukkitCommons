package cc.bukkit.world;

import org.bukkit.block.BlockFace;

public class LocationUtils {
	/**
	 * Use yaw to calc the BlockFace, You can use player.getFacing() in 1.13.2 and after builds.
	 * @param float yaw
	 * @return BlockFace blockFace
	 */
	public static BlockFace getYawFace(float yaw) {
		if (yaw > 315 && yaw <= 45) {
			return BlockFace.NORTH;
		} else if (yaw > 45 && yaw <= 135) {
			return BlockFace.EAST;
		} else if (yaw > 135 && yaw <= 225) {
			return BlockFace.SOUTH;
		} else {
			return BlockFace.WEST;
		}
	}
}
