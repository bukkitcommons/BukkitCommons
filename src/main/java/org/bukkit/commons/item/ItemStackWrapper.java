package org.bukkit.commons.item;

import org.bukkit.commons.item.interfaces.ItemStackSupplier;
import org.bukkit.inventory.ItemStack;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemStackWrapper implements ItemStackSupplier {
    private final ItemStack item;
    
    public ChainItemMeta getItemMetaReference() {
        return Items.getMetaReference(item);
    }
    
    @Override
    public ItemStack toItemStack() {
        return item;
    }
}
