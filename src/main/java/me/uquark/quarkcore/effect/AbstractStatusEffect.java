package me.uquark.quarkcore.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractStatusEffect extends StatusEffect {
    public final Identifier id;

    protected AbstractStatusEffect(String modid, String name, StatusEffectType type, int color) {
        super(type, color);
        id = new Identifier(modid, name);
    }

    public void register() {
        Registry.register(Registry.STATUS_EFFECT, id, this);
    }
}
