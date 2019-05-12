package cc.bukkit.misc;

import org.bukkit.plugin.Plugin;

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
	/**
	 * Check plugin is running on dev mode or not.
	 * @return
	 */
	public static boolean isDevEdition(Plugin plugin) {
		String version = plugin.getDescription().getVersion().toLowerCase();
		if(version.contains("dev")|version.contains("develop")|version.contains("alpha")|version.contains("beta")|version.contains("test")|version.contains("snapshot")|version.contains("preview")) {
			return true;
		}else {
			return false;
		}
	}
}
