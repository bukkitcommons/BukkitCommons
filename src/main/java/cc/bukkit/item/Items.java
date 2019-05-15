package cc.bukkit.item;

import java.text.DecimalFormat;
import java.util.function.Consumer;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import lombok.experimental.UtilityClass;

@UtilityClass
public  class Items {
    public static ItemStack orElse(ItemStack itemStack, Consumer<ItemStack> consumer) {
        if (itemStack != null)
            consumer.accept(itemStack);
        return itemStack;
    }
    
    public static ItemMetaReference getMetaReference(ItemStack itemStack) {
        return new ItemMetaReference(itemStack, itemStack.getItemMeta());
    }
    
    public static ItemStackWrapper createItem(Material type) {
        return acquireItemWrapper(new ItemStack(type));
    }
    
    public static ItemStackWrapper acquireItemWrapper(ItemStack itemStack) {
        return new ItemStackWrapper(itemStack);
    }
        
    public static ItemMetaReference createItemAndAcquireMetaReference(Material type) {
        return getMetaReference(new ItemStack(type));
    }
    
    public static ItemStackWrapper createItem(Material type, int amount) {
        return acquireItemWrapper(new ItemStack(type, amount));
    }
    
    public static ItemMetaReference createItemAndAcquireMetaReference(Material type, int amount) {
        return getMetaReference(new ItemStack(type, amount));
    }
    
    public static ChainItemMeta createItemAndAcquireChainMetaReference(Material type, int amount) {
        return getMetaReference(new ItemStack(type, amount)).chain();
    }
    
    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage) {
        return acquireItemWrapper(new ItemStack(type, amount, damage));
    }
    
    @SuppressWarnings("deprecation")
    public static ItemMetaReference createItemAndAcquireMetaReference(Material type, int amount, short damage) {
        return getMetaReference(new ItemStack(type, amount, damage));
    }
    
    @SuppressWarnings("deprecation")
    public static ChainItemMeta createItemAndAcquireChainMetaReference(Material type, int amount, short damage) {
        return getMetaReference(new ItemStack(type, amount, damage)).chain();
    }

    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage, Byte data) {
        return acquireItemWrapper(new ItemStack(type, amount, damage, data));
    }
    
    @SuppressWarnings("deprecation")
    public static ItemMetaReference createItemAndAcquireMetaReference(Material type, int amount, short damage, Byte data) {
        return getMetaReference(new ItemStack(type, amount, damage, data));
    }
    
    @SuppressWarnings("deprecation")
    public static ChainItemMeta createItemAndAcquireChainMetaReference(Material type, int amount, short damage, Byte data) {
        return getMetaReference(new ItemStack(type, amount, damage, data)).chain();
    }
    
    public static ItemMetaClip createItemMetaClip() {
        return new ItemMetaClip();
    }
    
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
	/**
	 * Get item's displayname.
	 * @param ItemStack iStack
	 * @return String itemDisplayName/Material name if no custom display name.
	 */
	public static String getDisplayName(ItemStack iStack){
		ItemStack is = iStack.clone();
		
		if(is.hasItemMeta()&&is.getItemMeta().hasDisplayName()) {
			return is.getItemMeta().getDisplayName();
		}else {
			return is.getType().name();
		}
		
	}
}
