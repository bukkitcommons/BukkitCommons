package org.bukkit.commons.test.item;

import org.bukkit.Material;
import org.bukkit.commons.item.Items;
import org.bukkit.inventory.ItemStack;

public class ItemsTest {
    public void test() {
        ItemStack itemStack = Items.createItem(Material.AIR, 5)
                                   .getItemMetaReference()
                                   .setUnbreakable(true)
                                   .setDisplayName("test")
                                   .toItemStack();
        
        itemStack.clone();
    }
}
