package cc.bukkit.inventory.interfaces;

import org.bukkit.inventory.Inventory;

@FunctionalInterface
public interface InventorySupplier {
    /**
     * 
     * @return
     */
    public Inventory toInventory();
}
