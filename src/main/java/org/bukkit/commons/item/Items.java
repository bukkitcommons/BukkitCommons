package org.bukkit.commons.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.experimental.UtilityClass;

@UtilityClass
public  class Items {
    public static ChainItemMeta getMetaReference(ItemStack itemStack) {
        return new ChainItemMeta(itemStack, new ItemMetaReference(itemStack, itemStack.getItemMeta()));
    }
    
    public static ItemStackWrapper createItem(Material type) {
        return new ItemStackWrapper(new ItemStack(type));
    }
        
    public static ChainItemMeta createItemAndAcquireMetaReference(Material type) {
        return getMetaReference(new ItemStack(type));
    }
    
    public static ItemStackWrapper createItem(Material type, int amount) {
        return new ItemStackWrapper(new ItemStack(type, amount));
    }
    
    public static ChainItemMeta createItemAndAcquireMetaReference(Material type, int amount) {
        return getMetaReference(new ItemStack(type, amount));
    }
    
    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage) {
        return new ItemStackWrapper(new ItemStack(type, amount, damage));
    }
    
    @SuppressWarnings("deprecation")
    public static ChainItemMeta createItemAndAcquireMetaReference(Material type, int amount, short damage) {
        return getMetaReference(new ItemStack(type, amount, damage));
    }

    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage, Byte data) {
        return new ItemStackWrapper(new ItemStack(type, amount, damage, data));
    }
    
    @SuppressWarnings("deprecation")
    public static ChainItemMeta createItemAndAcquireMetaReference(Material type, int amount, short damage, Byte data) {
        return getMetaReference(new ItemStack(type, amount, damage, data));
    }
    
    public static ItemMetaClip createItemMetaClip() {
        return new ItemMetaClip();
    }
}
