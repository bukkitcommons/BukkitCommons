package cc.bukkit.inventory;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cc.bukkit.inventory.interfaces.InventorySupplier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InventoryCreator implements InventorySupplier {
    private final Inventory inventory;
    
    public static ItemStack BREAK = new ItemStack(Material.BARRIER);

    @Override
    public Inventory toInventory() {
        return inventory;
    }
    
    /**
     * 
     * @param type
     * @return
     */
    public InventoryCreator fill(Material type) {
        return fill(new ItemStack(type));
    }
    
    /**
     * 
     * @param itemStack
     * @return
     */
    public InventoryCreator fill(ItemStack itemStack) {
        return fill(itemStack, 0, inventory.getSize());
    }
    
    /**
     * 
     * @param function
     * @return
     */
    public InventoryCreator fill(BiFunction<Integer, ItemStack, ItemStack> function) {
        return fill(function, 0, inventory.getSize());
    }
    
    public InventoryCreator fill(BiFunction<Integer, ItemStack, ItemStack> function, int startIndexInclusive, int endIndexExclusive) {
        int size = inventory.getSize();
        int startAt = startIndexInclusive < size ? startIndexInclusive : size - 1;
        int endAt = endIndexExclusive > size ? size : endIndexExclusive;
        
        for (int i = startAt; i < endAt; i++) {
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack == null) {
                ItemStack item = function.apply(i, itemStack);
                
                if (item == BREAK)
                    break;
                
                inventory.setItem(i, item);
            }
        }
        
        return this;
    }
    
    /**
     * 
     * @param itemStack
     * @param startIndexInclusive
     * @param endIndexExclusive
     * @return
     */
    public InventoryCreator fill(ItemStack itemStack, int startIndexInclusive, int endIndexExclusive) {
        int size = inventory.getSize();
        int startAt = startIndexInclusive < size ? startIndexInclusive : size - 1;
        int endAt = endIndexExclusive > size ? size : endIndexExclusive;
        
        for (int i = startAt; i < endAt; i++) {
            if (inventory.getItem(i) == null)
                inventory.setItem(i, itemStack);
        }
        
        return this;
    }
    
    /**
     * 
     * @param type
     * @param itemStack
     * @return
     */
    public InventoryCreator replace(Material type, ItemStack itemStack) {
        return forEachItems((i, item) -> {
            if (item.getType() == type)
                inventory.setItem(i, itemStack);
            }, 0, inventory.getSize());
    }
    
    /**
     * 
     * @param type
     * @param itemStack
     * @param startIndexInclusive
     * @param endIndexExclusive
     * @return
     */
    public InventoryCreator replace(Material type, ItemStack itemStack, int startIndexInclusive, int endIndexExclusive) {
        return forEachItems((i, item) -> {
            if (item.getType() == type)
                inventory.setItem(i, itemStack);
            }, startIndexInclusive, endIndexExclusive);
    }
    
    /**
     * 
     * @param beReplace
     * @param itemStack
     * @return
     */
    public InventoryCreator replace(ItemStack beReplace, ItemStack itemStack) {
        return forEachItems((i, item) -> {
            if (beReplace.equals(item))
                inventory.setItem(i, itemStack);
            }, 0, inventory.getSize());
    }
    
    /**
     * 
     * @param beReplace
     * @param itemStack
     * @return
     */
    public InventoryCreator replace(ItemStack beReplace, ItemStack itemStack, int startIndexInclusive, int endIndexExclusive) {
        return forEachItems((i, item) -> {
            if (beReplace.equals(item))
                inventory.setItem(i, itemStack);
            }, startIndexInclusive, endIndexExclusive);
    }
    
    /**
     * 
     * @param consumer
     * @return
     */
    public InventoryCreator forEachItems(BiConsumer<Integer, ItemStack> consumer) {
        return forEachItems(consumer, 0, inventory.getSize());
    }
    
    /**
     * 
     * @param consumer
     * @param startIndexInclusive
     * @param endIndexExclusive
     * @return
     */
    public InventoryCreator forEachItems(BiConsumer<Integer, ItemStack> consumer, int startIndexInclusive, int endIndexExclusive) {
        int size = inventory.getSize();
        int startAt = startIndexInclusive < size ? startIndexInclusive : size - 1;
        int endAt = endIndexExclusive > size ? size : endIndexExclusive;
        
        for (int i = startAt; i < endAt; i++) {
            ItemStack item = inventory.getItem(i);
            if (item != null)
                consumer.accept(i, item);
        }
        return this;
    }
    
    /**
     * 
     * @param itemStack
     * @return
     */
    public InventoryCreator addItemToEmptySlot(ItemStack itemStack) {
        inventory.setItem(inventory.firstEmpty(), itemStack);
        return this;
    }
}
