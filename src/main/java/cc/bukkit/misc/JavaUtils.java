package cc.bukkit.misc;

public class JavaUtils {
	/**
	 * Get this class available or not
	 * @param String qualifiedName
	 * @return boolean Available
	 */
	public static boolean isClassAvailable(String qualifiedName) {
		try {
			Class.forName(qualifiedName);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
