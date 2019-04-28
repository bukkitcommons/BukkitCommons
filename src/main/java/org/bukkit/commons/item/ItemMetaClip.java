package org.bukkit.commons.item;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.commons.item.interfaces.ItemMetaSupplier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;

import com.google.common.collect.Multimap;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemMetaClip implements ItemMetaSupplier {
    private final static ItemMeta EMPTY_META = new ItemStack(Material.AIR).getItemMeta();
    
    protected final ItemMeta meta = new ItemStack(Material.AIR).getItemMeta();
    
    @Override
    public ItemMeta toItemMeta() {
        return meta;
    }
    
    public ItemMeta applyFor(ItemMeta itemMeta) {
        if (itemMeta.getDisplayName().equals(EMPTY_META.getDisplayName()))
            itemMeta.setDisplayName(meta.getDisplayName());
        
        if (itemMeta.getEnchants().isEmpty() && meta.hasEnchants())
            for (Entry<Enchantment, Integer> enchantment : meta.getEnchants().entrySet())
                itemMeta.addEnchant(enchantment.getKey(), enchantment.getValue(), true);
        
        if (!itemMeta.hasLore() && meta.hasLore())
            itemMeta.setLore(meta.getLore());
        
        return itemMeta;
    }
    
    // ------------------------------
    // Setter
    // ------------------------------

    public ItemMetaClip addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        meta.addEnchant(ench, level, ignoreLevelRestriction);
        return this;
    }

    public ItemMetaClip removeEnchant(Enchantment ench) {
        meta.removeEnchant(ench);
        return this;
    }

    public ItemMetaClip getAttributeModifiers(EquipmentSlot slot) {
        meta.getAttributeModifiers(slot);
        return this;
    }

    public ItemMetaClip getAttributeModifiers(Attribute attribute) {
        meta.getAttributeModifiers(attribute);
        return this;
    }

    public ItemMetaClip addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        meta.addAttributeModifier(attribute, modifier);
        return this;
    }

    public ItemMetaClip removeAttributeModifier(Attribute attribute) {
        meta.removeAttributeModifier(attribute);
        return this;
    }

    public ItemMetaClip removeAttributeModifier(EquipmentSlot slot) {
        meta.removeAttributeModifier(slot);
        return this;
    }

    public ItemMetaClip removeAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        meta.removeAttributeModifier(attribute, modifier);
        return this;
    }
    
    public ItemMetaClip setAttributeModifiers(Multimap<Attribute, AttributeModifier> attributeModifiers) {
        meta.setAttributeModifiers(attributeModifiers);
        return this;
    }
    
    public ItemMetaClip setDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }
    
    public ItemMetaClip setLore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }
    
    public ItemMetaClip setLocalizedName(String name) {
        meta.setLocalizedName(name);
        return this;
    }
    
    public ItemMetaClip addItemFlags(ItemFlag... itemFlags) {
        meta.addItemFlags(itemFlags);
        return this;
    }

    public ItemMetaClip removeItemFlags(ItemFlag... itemFlags) {
        meta.removeItemFlags(itemFlags);
        return this;
    }

    public ItemMetaClip setUnbreakable(boolean unbreakable) {
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
