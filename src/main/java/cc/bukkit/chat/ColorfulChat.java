package cc.bukkit.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;

public class ColorfulChat {
	/**
     * Add colors on text with random custom colors
     * @param text need add color string
     * @param colorcode custom
     * @return added colors text
     */
	public static String colorfulRandom(String text, String... colorcode) {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		char[] chars = text.toCharArray();
		for (char c : chars) {
			buffer.append("§").append(colorcode[random.nextInt(colorcode.length)]).append(c);
		}
		return buffer.toString();
	}
	/**
     * Add colors on text with non-random custom colors
     * @param text need add color string
     * @param colorcode custom
     * @return added colors text
     */
	public static String colorfulNonRandom(String text, String... colorcode) {
		StringBuffer buffer = new StringBuffer();
		char[] chars = text.toCharArray();
		int loc = 0;
		for (char c : chars) {
			buffer.append("§").append(colorcode[loc]).append(c);
			loc++;
			if(!(colorcode.length<loc))
				loc=0;
		}
		return buffer.toString();
	}
	/**
     * Add colors on text with random colors
     * @param text need add color string
     * @param colorcode custom
     * @return added colors text
     */
	public static String colorfulRandom(String text) {
		String[] colorcode = getColors();
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		char[] chars = text.toCharArray();
		for (char c : chars) {
			buffer.append("§").append(colorcode[random.nextInt(colorcode.length)]).append(c);
		}
		return buffer.toString();
	}
	/**
     * Add colors on text with random colors
     * @param text need add color string
     * @param colorcode custom
     * @return added colors text
     */
	public static String colorfulNonRandom(String text) {
		String[] colorcode = getColors();
		StringBuffer buffer = new StringBuffer();
		char[] chars = text.toCharArray();
		int loc = 0;
		for (char c : chars) {
			buffer.append("§").append(colorcode[loc]).append(c);
			loc++;
			if(!(colorcode.length<loc))
				loc=0;
		}
		return buffer.toString();
	}
	/**
     * Get this bukkit version supported all colors.
     * @return Colors list on this server, how many is support decide the server version.
     */
	public static String[] getColors() {
		List<String> colorcodes = new ArrayList<>();
		for (ChatColor chatColor : ChatColor.values()) {
			colorcodes.add(chatColor.toString());
		}
		return colorcodes.toArray(new String[0]);
	}
}
