package org.bukkit.commons.test.item;

import org.bukkit.Material;
import org.bukkit.commons.item.Items;
import org.bukkit.inventory.ItemStack;

public class ItemsTest {
    public void test() {
        ItemStack item = new ItemStack(Material.AIR);
        ItemStack item_ = new ItemStack(Material.AIR);
        
        Items.getItemMetaReference(item)
             .setUnbreakable(true)
             .setDisplayName("test")
             .setMetaFor(item_);
    }
}
