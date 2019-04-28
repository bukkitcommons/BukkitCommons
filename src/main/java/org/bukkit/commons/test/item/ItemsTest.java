package org.bukkit.commons.test.item;

import org.bukkit.Material;
import org.bukkit.commons.item.ItemMetaReference;
import org.bukkit.commons.item.Items;
import org.bukkit.inventory.ItemStack;

public class ItemsTest {
    
    @SuppressWarnings("unused")
    public void test() {
        // reference
        ItemMetaReference reference = Items.createItem(Material.AIR, 5).getItemMetaReference();
        reference.setUnbreakable(true);
        reference.setDisplayName("test");
        
        // chain
        ItemStack itemStack = Items.createItemAndAcquireMetaReference(Material.AIR, 5).chain()
                                   .setUnbreakable(true)
                                   .setDisplayName("test")
                                   .toItemStack();
    }
}
