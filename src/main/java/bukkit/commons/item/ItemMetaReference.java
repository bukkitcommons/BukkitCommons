package bukkit.commons.item;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;

import com.google.common.collect.Multimap;

import bukkit.commons.item.interfaces.ItemMetaSupplier;
import bukkit.commons.item.interfaces.ItemStackSupplier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemMetaReference implements ItemMeta, ItemStackSupplier, ItemMetaSupplier {
    private final ItemStack item;
    private final ItemMeta meta;
    
    /**
     * 
     */
    @Override
    public ItemStack toItemStack() {
        return item;
    }
    
    /**
     * 
     */
    @Override
    public ItemMeta toItemMeta() {
        return meta;
    }
    
    /**
     * 
     * @return
     */
    public ChainItemMeta chain() {
        return new ChainItemMeta(item, meta);
    }
    
    // ------------------------------
    // Helper
    // ------------------------------
    
    private void applyMeta() {
        item.setItemMeta(meta);
    }
    
    private <E> E applyMeta(E e) {
        item.setItemMeta(meta);
        return e;
    }

    // ------------------------------
    // Setter
    // ------------------------------

    @Override
    public boolean addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        boolean result = meta.addEnchant(ench, level, ignoreLevelRestriction);
        return applyMeta(result);
    }

    @Override
    public boolean removeEnchant(Enchantment ench) {
        boolean result = meta.removeEnchant(ench);
        return applyMeta(result);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        Multimap<Attribute, AttributeModifier> result = meta.getAttributeModifiers(slot);
        return applyMeta(result);
    }

    @Override
    public Collection<AttributeModifier> getAttributeModifiers(Attribute attribute) {
        Collection<AttributeModifier> result = meta.getAttributeModifiers(attribute);
        return applyMeta(result);
    }

    @Override
    public boolean addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        boolean result = meta.addAttributeModifier(attribute, modifier);
        return applyMeta(result);
    }

    @Override
    public boolean removeAttributeModifier(Attribute attribute) {
        boolean result = meta.removeAttributeModifier(attribute);
        return applyMeta(result);
    }

    @Override
    public boolean removeAttributeModifier(EquipmentSlot slot) {
        boolean result = meta.removeAttributeModifier(slot);
        return applyMeta(result);
    }

    @Override
    public boolean removeAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        boolean result = meta.removeAttributeModifier(attribute, modifier);
        return applyMeta(result);
    }
    
    // ------------------------------
    // Void
    // ------------------------------
    
    @Override
    public void setAttributeModifiers(Multimap<Attribute, AttributeModifier> attributeModifiers) {
        meta.setAttributeModifiers(attributeModifiers);
        applyMeta();
    }
    
    @Override
    public void setDisplayName(String name) {
        meta.setDisplayName(name);
        applyMeta();
    }
    
    @Override
    public void setLore(List<String> lore) {
        meta.setLore(lore);
        applyMeta();
    }
    
    @Override
    public void setLocalizedName(String name) {
        meta.setLocalizedName(name);
        applyMeta();
    }
    
    @Override
    public void addItemFlags(ItemFlag... itemFlags) {
        meta.addItemFlags(itemFlags);
        applyMeta();
    }

    @Override
    public void removeItemFlags(ItemFlag... itemFlags) {
        meta.removeItemFlags(itemFlags);
        applyMeta();
    }

    @Override
    public void setUnbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        applyMeta();
    }
    
    // ------------------------------
    // Getter
    // ------------------------------
    
    @Override
    public Map<String, Object> serialize() {
        return meta.serialize();
    }
    
    @Override
    public boolean hasDisplayName() {
        return meta.hasDisplayName();
    }

    @Override
    public String getDisplayName() {
        return meta.getDisplayName();
    }

    @Override
    public boolean hasLocalizedName() {
        return meta.hasLocalizedName();
    }

    @Override
    public String getLocalizedName() {
        return meta.getLocalizedName();
    }

    @Override
    public boolean hasLore() {
        return meta.hasLore();
    }

    @Override
    public List<String> getLore() {
        return meta.getLore();
    }

    @Override
    public boolean hasEnchants() {
        return meta.hasEnchants();
    }

    @Override
    public boolean hasEnchant(Enchantment ench) {
        return meta.hasEnchant(ench);
    }

    @Override
    public int getEnchantLevel(Enchantment ench) {
        return meta.getEnchantLevel(ench);
    }

    @Override
    public Map<Enchantment, Integer> getEnchants() {
        return meta.getEnchants();
    }
    
    @Override
    public boolean hasConflictingEnchant(Enchantment ench) {
        return meta.hasConflictingEnchant(ench);
    }

    @Override
    public Set<ItemFlag> getItemFlags() {
        return meta.getItemFlags();
    }

    @Override
    public boolean hasItemFlag(ItemFlag flag) {
        return meta.hasItemFlag(flag);
    }

    @Override
    public boolean isUnbreakable() {
        return meta.isUnbreakable();
    }

    @Override
    public boolean hasAttributeModifiers() {
        return meta.hasAttributeModifiers();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers() {
        return meta.getAttributeModifiers();
    }

    @Override
    public CustomItemTagContainer getCustomTagContainer() {
        return meta.getCustomTagContainer();
    }

    @Override
    public ItemMeta clone() {
        return meta.clone();
    }

    @Override
    public Spigot spigot() {
        return meta.spigot();
    }
}
