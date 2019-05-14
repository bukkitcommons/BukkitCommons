package cc.bukkit.chat;

public class PrettifyFormatter {
	/**
	 * Converts a name like IRON_INGOT into Iron Ingot to improve readability
	 * 
	 * @param ugly
	 *            The string such as IRON_INGOT
	 * @return A nicer version, such as Iron Ingot
	 * 
	 */
	public static String prettifyText(String ugly) {
		String[] nameParts = ugly.split("_");
		if (nameParts.length==1) {
			return firstUppercase(ugly);
		}

		StringBuilder sb=new StringBuilder();
		for (String part : nameParts) {
			sb.append(firstUppercase(part)+" ");
		}

		return sb.toString();
	}
	
	public static String firstUppercase(String string) {
		if (string.length()>1) {
			return Character.toUpperCase(string.charAt(0))+string.substring(1).toLowerCase();
		} else {
			return string.toUpperCase();
		}
	}
}
