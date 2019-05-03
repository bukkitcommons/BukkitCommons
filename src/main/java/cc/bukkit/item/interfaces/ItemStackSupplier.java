package cc.bukkit.item.interfaces;

import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface ItemStackSupplier {
    /**
     * 
     * @return
     */
    public ItemStack toItemStack();
}
