package org.bukkit.commons.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.experimental.UtilityClass;

@UtilityClass
public  class Items {
    public static ItemMetaReference getMetaReference(ItemStack itemStack) {
        return new ItemMetaReference(itemStack, itemStack.getItemMeta());
    }
    
    public static ItemStackWrapper createItem(Material type) {
        return new ItemStackWrapper(new ItemStack(type));
    }
        
    public static ItemMetaReference createItemAndAcquireMetaReference(Material type) {
        return getMetaReference(new ItemStack(type));
    }
    
    public static ItemStackWrapper createItem(Material type, int amount) {
        return new ItemStackWrapper(new ItemStack(type, amount));
    }
    
    public static ItemMetaReference createItemAndAcquireMetaReference(Material type, int amount) {
        return getMetaReference(new ItemStack(type, amount));
    }
    
    public static ChainItemMeta createItemAndAcquireChainMetaReference(Material type, int amount) {
        return getMetaReference(new ItemStack(type, amount)).chain();
    }
    
    @SuppressWarnings("deprecation")
    public static ItemStackWrapper createItem(Material type, int amount, short damage) {
        return new ItemStackWrapper(new ItemStack(type, amount, damage));
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
        return new ItemStackWrapper(new ItemStack(type, amount, damage, data));
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
}
