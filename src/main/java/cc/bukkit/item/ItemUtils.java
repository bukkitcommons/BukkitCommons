package cc.bukkit.item;

import java.text.DecimalFormat;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
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
	/**
	 * Covert ItemStack to YAML string.
	 * @param ItemStack iStack
	 * @return String serialized itemStack
	 */
	public static String serialize(ItemStack iStack) {
		YamlConfiguration cfg = new YamlConfiguration();
		cfg.set("item", iStack);
		return cfg.saveToString();
	}
	/**
	 * Covert YAML string to ItemStack.
	 * @param String serialized itemStack
	 * @return ItemStack iStack
	 */
	public static ItemStack deserialize(String config) throws InvalidConfigurationException {
		YamlConfiguration cfg = new YamlConfiguration();
		cfg.loadFromString(config);
		cfg.getString("item");
		ItemStack stack = cfg.getItemStack("item");
		return stack;
	}
}
