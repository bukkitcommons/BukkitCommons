package org.bukkit.commons.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.experimental.UtilityClass;

@UtilityClass
public  class Items {
    public static ChainItemMeta getItemMetaReference(ItemStack itemStack) {
        return new ChainItemMeta(itemStack, new ItemMetaReference(itemStack, itemStack.getItemMeta()));
    }
    
    public static ItemStackWrapper createItem(Material type) {
        return new ItemStackWrapper(new ItemStack(type));
    }
    
    public static ItemStackWrapper createItem(Material type, int amount) {
        return new ItemStackWrapper(new ItemStack(type, amount));
    }
    
    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage) {
        return new ItemStackWrapper(new ItemStack(type, amount, damage));
    }

    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage, Byte data) {
        return new ItemStackWrapper(new ItemStack(type, amount, damage, data));
    }
}
