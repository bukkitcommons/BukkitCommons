package cc.bukkit.inventory;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import com.google.common.collect.Lists;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Inventories {
    
    public InventoryCreator acquireInventoryCreator(Inventory inventory) {
        return new InventoryCreator(inventory);
    }
    
    /**
     * 
     * @param inventory
     * @param itemToTake
     * @return
     */
    @SuppressWarnings("deprecation")
    public boolean takeItem(@Nonnull Inventory inventory, @Nonnull ItemStack itemToTake) {
        int totalMatchedAmount = 0;
        int toTakeAmount = itemToTake.getAmount();
        List<Integer> matchedSlots = Lists.newArrayList();
        
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            
            if (itemStack == null)
                continue;
            
            // match item data
            if (itemStack.getType() == itemToTake.getType() &&
                itemStack.getDurability() == itemToTake.getDurability() &&
                itemStack.getItemMeta().equals(itemToTake.getItemMeta())) {
                
                int stackAmount = itemStack.getAmount();
                
                if (stackAmount >= toTakeAmount) {
                    int afterAmount = stackAmount - toTakeAmount;
                    
                    if (afterAmount > 0) {
                        // more than to take
                        itemStack.setAmount(stackAmount - toTakeAmount);
                        return true;
                    } else {
                        // perfect match
                        inventory.setItem(i, null);
                        return true;
                    }
                } else {
                    // insufficient amount
                    totalMatchedAmount += stackAmount;
                    matchedSlots.add(i);
                    
                    // sufficient combination, we will end in this circle
                    if (totalMatchedAmount >= toTakeAmount) {
                        int takenAmount = 0;
                        int afterAmount = totalMatchedAmount - toTakeAmount;
                        
                        if (afterAmount > 0) {
                            // more than to take
                            for (int index : matchedSlots) {
                                ItemStack item = inventory.getItem(index);
                                
                                if (item == null)
                                    continue;
                                
                                // this will always bigger than stack amount except sometimes at the last item
                                int toTake = toTakeAmount - takenAmount;
                                stackAmount = item.getAmount();
                                
                                if (stackAmount <= toTake) {
                                    takenAmount += stackAmount;
                                    inventory.setItem(index, null);
                                } else {
                                    takenAmount += toTake;
                                    item.setAmount(stackAmount - toTake);
                                }
                                
                                // let's break faster
                                if (toTakeAmount == takenAmount) {
                                    return true;
                                }
                            }
                            
                            // how it comes here?
                            return true;
                        } else {
                            // perfect match
                            for (int index : matchedSlots)
                                inventory.setItem(index, null);
                            
                            return true;
                        }
                    }
                }
            }
        }
        
        // not found at all or actually insufficient
        return false;
    }
    /**
	 * Counts the number of items in the given inventory where
	 * Util.matches(inventory item, item) is true.
	 * 
	 * @param inv
	 *            The inventory to search
	 * @param item
	 *            The ItemStack to search for
	 * @return The number of items that match in this inventory.
	 */
	public static int countItems(Inventory inv, ItemStack item) {
		int items = 0;
		HashMap<Integer, ? extends ItemStack> map = inv.all(item);
		for (Integer locationInInventory : map.keySet()) {
			items+=inv.getItem(locationInInventory).getAmount();
		}
		return items;
	}
    
}
