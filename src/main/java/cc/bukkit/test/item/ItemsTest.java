package cc.bukkit.test.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import cc.bukkit.item.ItemMetaReference;
import cc.bukkit.item.Items;

public class ItemsTest {
    
    @SuppressWarnings("unused")
    public void test() {
        // reference
        ItemMetaReference reference = Items.createItemAndAcquireMetaReference(Material.AIR, 5);
        reference.setUnbreakable(true);
        reference.setDisplayName("test");
        
        // chain
        ItemStack itemStack = Items.createItemAndAcquireChainMetaReference(Material.AIR, 5)
                                   .setUnbreakable(true)
                                   .setDisplayName("test")
                                   .toItemStack();
    }
}
