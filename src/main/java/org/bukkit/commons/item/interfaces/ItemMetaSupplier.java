package org.bukkit.commons.item.interfaces;

import org.bukkit.inventory.meta.ItemMeta;

@FunctionalInterface
public interface ItemMetaSupplier {
    public ItemMeta toItemMeta();
}
