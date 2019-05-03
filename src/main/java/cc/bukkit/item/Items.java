package cc.bukkit.item;

import java.util.function.Consumer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
}
