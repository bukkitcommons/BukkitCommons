package bukkit.commons.test.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import bukkit.commons.item.ItemMetaReference;
import bukkit.commons.item.Items;

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
