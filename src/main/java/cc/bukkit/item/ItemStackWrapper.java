package cc.bukkit.item;

import java.util.function.Consumer;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.bukkit.item.interfaces.ItemMetaSupplier;
import cc.bukkit.item.interfaces.ItemStackSupplier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemStackWrapper implements ItemStackSupplier, ItemMetaSupplier {
    private final ItemStack item;
    
    public ItemMetaReference getItemMetaReference() {
        return Items.getMetaReference(item);
    }
    
    @Override
    public ItemStack toItemStack() {
        return item;
    }

    @Override
    public ItemMeta toItemMeta() {
        return item.getItemMeta();
    }
    
    public ItemStackWrapper orElse(Consumer<ItemStack> consumer) {
        if (item != null)
            consumer.accept(item);
        return this;
    }
}
