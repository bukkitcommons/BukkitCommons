package cc.bukkit.chat;

public class RomanFormatter {
	private static final String[] ROMAN = { "X", "IX", "V", "IV", "I" };
	private static final int[] DECIMAL = { 10, 9, 5, 4, 1 };
	
	public static String toRomain(Integer value) {
		return toRoman(value.intValue());
	}

	/**
	 * Converts the given number to roman numerals. If the number is >= 40 or <=
	 * 0, it will just return the number as a string.
	 * 
	 * @param n
	 *            The number to convert
	 * @return The roman numeral representation of this number, or the number in
	 *         decimal form as a string if n <= 0 || n >= 40.
	 */
	public static String toRoman(int n) {
		if (n <= 0 || n >= 40)
			return "" + n;
		String roman = "";
		for (int i = 0; i < ROMAN.length; i++) {
			while (n >= DECIMAL[i]) {
				n -= DECIMAL[i];
				roman += ROMAN[i];
			}
		}
		return roman;
	}
}
