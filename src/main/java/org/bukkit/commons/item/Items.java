package org.bukkit.commons.item;

import org.bukkit.inventory.ItemStack;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Items {
    public static ChainItemMeta getItemMetaReference(ItemStack itemStack) {
        return new ChainItemMeta(new ItemMetaReference(itemStack, itemStack.getItemMeta()));
    }
}
