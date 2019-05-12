package cc.bukkit.item;

import java.text.DecimalFormat;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class ItemUtils {
	/**
	 * Gets the percentage (Without trailing %) damage on a tool.
	 * 
	 * @param item
	 *            The ItemStack of tools to check
	 * @return The percentage 'health' the tool has. (Opposite of total damage)
	 */
	public static String getToolPercentage(ItemStack item) {
		double dura = ((Damageable)item.getItemMeta()).getDamage();;
		double max = item.getType().getMaxDurability();
		DecimalFormat formatter = new DecimalFormat("0");
		return formatter.format((1 - dura / max) * 100.0);
	}
}
