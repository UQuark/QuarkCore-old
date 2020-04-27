package me.uquark.quarkcore.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractPotion extends Potion {
    public final Identifier id;

    public AbstractPotion(String modid, String name, StatusEffectInstance... type) {
        super(type);
        id = new Identifier(modid, name);
    }

    public void register() {
        Registry.register(Registry.POTION, id, this);
    }
}
