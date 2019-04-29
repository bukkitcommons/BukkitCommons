package org.bukkit.commons.inventory;

import java.util.List;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Inventories {
    
    /**
     * 
     * @param inventory
     * @param itemToTake
     * @return
     */
    @SuppressWarnings("deprecation")
    public boolean takeItem(Inventory inventory, ItemStack itemToTake) {
        int totalMatchedAmount = 0;
        int toTakeAmount = itemToTake.getAmount();
        List<Integer> matchedSlots = Lists.newArrayList();
        
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            
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
                            
                            // h
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
    
}
