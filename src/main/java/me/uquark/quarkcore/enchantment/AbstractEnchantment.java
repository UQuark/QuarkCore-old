package me.uquark.quarkcore.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AbstractEnchantment extends Enchantment {
    public final Identifier id;

    protected AbstractEnchantment(String modid, String name, Rarity rarity, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(rarity, type, slotTypes);
        id = new Identifier(modid, name);
    }

    public void register() {
        Registry.register(Registry.ENCHANTMENT, id, this);
    }

    public boolean isEnchanted(ItemStack stack) {
        return getEnchantmentLevel(stack) > 0;
    }

    public int getEnchantmentLevel(ItemStack stack) {
        return EnchantmentHelper.getLevel(this, stack);
    }
}
