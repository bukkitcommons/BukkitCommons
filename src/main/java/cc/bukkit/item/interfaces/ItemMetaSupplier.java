package cc.bukkit.item.interfaces;

import org.bukkit.inventory.meta.ItemMeta;

@FunctionalInterface
public interface ItemMetaSupplier {
    /**
     * 
     * @return
     */
    public ItemMeta toItemMeta();
}
