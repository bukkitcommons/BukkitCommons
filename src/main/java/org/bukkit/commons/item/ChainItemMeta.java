package org.bukkit.commons.item;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.commons.item.interfaces.ItemStackSupplier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;

import com.google.common.collect.Multimap;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChainItemMeta implements ItemStackSupplier {
    protected final ItemStack item;
    protected final ItemMeta meta;
    
    public ItemMeta toItemMeta() {
        return meta;
    }
    
    @Override
    public ItemStack toItemStack() {
        assert item != null : "TRAP";
        return item;
    }
    
    // Performance things
    public ChainItemMeta setMetaFor(ItemStack itemStack) {
        itemStack.setItemMeta(meta);
        return this;
    }
    
    public ChainItemMeta setMetaFor(ItemStack... itemStacks) {
        for (ItemStack itemStack : itemStacks)
            itemStack.setItemMeta(meta);
        return this;
    }

    // ------------------------------
    // Setter
    // ------------------------------

    public ChainItemMeta addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        meta.addEnchant(ench, level, ignoreLevelRestriction);
        return this;
    }

    public ChainItemMeta removeEnchant(Enchantment ench) {
        meta.removeEnchant(ench);
        return this;
    }

    public ChainItemMeta getAttributeModifiers(EquipmentSlot slot) {
        meta.getAttributeModifiers(slot);
        return this;
    }

    public ChainItemMeta getAttributeModifiers(Attribute attribute) {
        meta.getAttributeModifiers(attribute);
        return this;
    }

    public ChainItemMeta addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        meta.addAttributeModifier(attribute, modifier);
        return this;
    }

    public ChainItemMeta removeAttributeModifier(Attribute attribute) {
        meta.removeAttributeModifier(attribute);
        return this;
    }

    public ChainItemMeta removeAttributeModifier(EquipmentSlot slot) {
        meta.removeAttributeModifier(slot);
        return this;
    }

    public ChainItemMeta removeAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        meta.removeAttributeModifier(attribute, modifier);
        return this;
    }
    
    public ChainItemMeta setAttributeModifiers(Multimap<Attribute, AttributeModifier> attributeModifiers) {
        meta.setAttributeModifiers(attributeModifiers);
        return this;
    }
    
    public ChainItemMeta setDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }
    
    public ChainItemMeta setLore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }
    
    public ChainItemMeta setLocalizedName(String name) {
        meta.setLocalizedName(name);
        return this;
    }
    
    public ChainItemMeta addItemFlags(ItemFlag... itemFlags) {
        meta.addItemFlags(itemFlags);
        return this;
    }

    public ChainItemMeta removeItemFlags(ItemFlag... itemFlags) {
        meta.removeItemFlags(itemFlags);
        return this;
    }

    public ChainItemMeta setUnbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }
    
    // ------------------------------
    // Getter
    // ------------------------------
    
    public Map<String, Object> serialize() {
        return meta.serialize();
    }
    
    public boolean hasDisplayName() {
        return meta.hasDisplayName();
    }

    public String getDisplayName() {
        return meta.getDisplayName();
    }

    public boolean hasLocalizedName() {
        return meta.hasLocalizedName();
    }

    public String getLocalizedName() {
        return meta.getLocalizedName();
    }

    public boolean hasLore() {
        return meta.hasLore();
    }

    public List<String> getLore() {
        return meta.getLore();
    }

    public boolean hasEnchants() {
        return meta.hasEnchants();
    }

    public boolean hasEnchant(Enchantment ench) {
        return meta.hasEnchant(ench);
    }

    public int getEnchantLevel(Enchantment ench) {
        return meta.getEnchantLevel(ench);
    }

    public Map<Enchantment, Integer> getEnchants() {
        return meta.getEnchants();
    }
    
    public boolean hasConflictingEnchant(Enchantment ench) {
        return meta.hasConflictingEnchant(ench);
    }

    public Set<ItemFlag> getItemFlags() {
        return meta.getItemFlags();
    }

    public boolean hasItemFlag(ItemFlag flag) {
        return meta.hasItemFlag(flag);
    }

    public boolean isUnbreakable() {
        return meta.isUnbreakable();
    }

    public boolean hasAttributeModifiers() {
        return meta.hasAttributeModifiers();
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers() {
        return meta.getAttributeModifiers();
    }

    public CustomItemTagContainer getCustomTagContainer() {
        return meta.getCustomTagContainer();
    }

    public ItemMeta clone() {
        return meta.clone();
    }

    public org.bukkit.inventory.meta.ItemMeta.Spigot spigot() {
        return meta.spigot();
    }
}
