package me.uquark.quarkcore.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractItem extends Item {
    public final Identifier id;

    public AbstractItem(String modid, String name, Settings settings) {
        super(settings);
        id = new Identifier(modid, name);
    }

    public void register() {
        Registry.register(Registry.ITEM, id, this);
    }
}
