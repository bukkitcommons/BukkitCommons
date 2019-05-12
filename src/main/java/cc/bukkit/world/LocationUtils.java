package cc.bukkit.world;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

import cc.bukkit.math.NumberUtils;

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
	/**
	 * Check a Location is in a region or not, include the region border
	 * @param Location needCheckLocation, Location regionLocation1, Location regionLocation2
	 * @return boolean inORnot
	 */
	public static boolean inRegion3D_checkBorder(Location needCheckLocation, Location loc1, Location loc2) {
		int loc1X = loc1.getBlockX();
		int loc1Y = loc1.getBlockY();
		int loc1Z = loc1.getBlockZ();
		int loc2X = loc2.getBlockX();
		int loc2Y = loc2.getBlockY();
		int loc2Z = loc2.getBlockZ();
		if(!NumberUtils.between_checkBorder(needCheckLocation.getBlockX(), loc1X, loc2X))
			return false;
		if(!NumberUtils.between_checkBorder(needCheckLocation.getBlockY(), loc1Y, loc2Y))
			return false;
		if(!NumberUtils.between_checkBorder(needCheckLocation.getBlockY(), loc1Z, loc2Z))
			return false;
		return true;
		
	}
	/**
	 * Check a Location is in a region or not, exclude the region border
	 * @param Location needCheckLocation, Location regionLocation1, Location regionLocation2
	 * @return boolean inORnot
	 */
	public static boolean inRegion3D(Location needCheckLocation, Location loc1, Location loc2) {
		int loc1X = loc1.getBlockX();
		int loc1Y = loc1.getBlockY();
		int loc1Z = loc1.getBlockZ();
		int loc2X = loc2.getBlockX();
		int loc2Y = loc2.getBlockY();
		int loc2Z = loc2.getBlockZ();
		if(!NumberUtils.between(needCheckLocation.getBlockX(), loc1X, loc2X))
			return false;
		if(!NumberUtils.between(needCheckLocation.getBlockY(), loc1Y, loc2Y))
			return false;
		if(!NumberUtils.between(needCheckLocation.getBlockY(), loc1Z, loc2Z))
			return false;
		return true;
	}
	/**
	 * Check a Location is in a region or not, include the region border
	 * @param Location needCheckLocation, Location regionLocation1, Location regionLocation2
	 * @return boolean inORnot
	 */
	public static boolean inRegion2D_checkBorder(Location needCheckLocation, Location loc1, Location loc2) {
		int loc1X = loc1.getBlockX();
		int loc1Z = loc1.getBlockZ();
		int loc2X = loc2.getBlockX();
		int loc2Z = loc2.getBlockZ();
		if(!NumberUtils.between_checkBorder(needCheckLocation.getBlockX(), loc1X, loc2X))
			return false;
		if(!NumberUtils.between_checkBorder(needCheckLocation.getBlockY(), loc1Z, loc2Z))
			return false;
		return true;
		
	}
	/**
	 * Check a Location is in a region or not, exclude the region border
	 * @param Location needCheckLocation, Location regionLocation1, Location regionLocation2
	 * @return boolean inORnot
	 */
	public static boolean inRegion2D(Location needCheckLocation, Location loc1, Location loc2) {
		int loc1X = loc1.getBlockX();
		int loc1Z = loc1.getBlockZ();
		int loc2X = loc2.getBlockX();
		int loc2Z = loc2.getBlockZ();
		if(!NumberUtils.between(needCheckLocation.getBlockX(), loc1X, loc2X))
			return false;
		if(!NumberUtils.between(needCheckLocation.getBlockY(), loc1Z, loc2Z))
			return false;
		return true;
	}
	/**
	 * Check two Location is equals on 3D.
	 * @param Location loc1, Location loc2
	 * @return boolean yes or not
	 */
	public static boolean equalsLocation3D(Location loc1, Location loc2) {
		boolean equalsX = (loc1.getX()==loc2.getX());
		boolean equalsY = (loc1.getY()==loc2.getY());
		boolean equalsZ = (loc1.getZ()==loc2.getZ());
		if(equalsX==equalsY==equalsZ)
			return true;
		return false;
	}
	/**
	 * Check two Location is equals on 2D.
	 * @param Location loc1, Location loc2
	 * @return boolean yes or not
	 */
	public static boolean equalsLocation2D(Location loc1, Location loc2) {
		boolean equalsX = (loc1.getX()==loc2.getX());
		boolean equalsZ = (loc1.getZ()==loc2.getZ());
		if(equalsX==equalsZ)
			return true;
		return false;
	}
	
	/**
	 * Check two Location is equals on 3D block position.
	 * @param Location loc1, Location loc2
	 * @return boolean yes or not
	 */
	public static boolean equalsLocation3DBlockPosition(Location loc1, Location loc2) {
		boolean equalsX = (loc1.getBlockX()==loc2.getBlockX());
		boolean equalsY = (loc1.getBlockY()==loc2.getBlockY());
		boolean equalsZ = (loc1.getBlockZ()==loc2.getBlockZ());
		if(equalsX==equalsY==equalsZ)
			return true;
		return false;
	}
	/**
	 * Check two Location is equals on 2D block position.
	 * @param Location loc1, Location loc2
	 * @return boolean yes or not
	 */
	public static boolean equalsLocation2DBlockPosition(Location loc1, Location loc2) {
		boolean equalsX = (loc1.getBlockX()==loc2.getBlockX());
		boolean equalsZ = (loc1.getBlockZ()==loc2.getBlockZ());
		if(equalsX==equalsZ)
			return true;
		return false;
	}
}
