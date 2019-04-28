package org.bukkit.commons.item;

import org.bukkit.commons.item.interfaces.ItemMetaSupplier;
import org.bukkit.commons.item.interfaces.ItemStackSupplier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemStackWrapper implements ItemStackSupplier, ItemMetaSupplier {
    private final ItemStack item;
    
    public ItemMetaReference getItemMetaReference() {
        return Items.getMetaReference(item);
    }
    
    @Override
    public ItemStack toItemStack() {
        return item;
    }

    @Override
    public ItemMeta toItemMeta() {
        return item.getItemMeta();
    }
}
