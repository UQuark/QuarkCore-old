package me.uquark.quarkcore.item;

import me.uquark.quarkcore.base.AbstractMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractItem extends Item {
    public final Identifier id;

    public AbstractItem(AbstractMod mod, String name, Settings settings) {
        super(settings);
        id = new Identifier(mod.modid, name);
    }

    public void register() {
        Registry.register(Registry.ITEM, id, this);
    }
}
