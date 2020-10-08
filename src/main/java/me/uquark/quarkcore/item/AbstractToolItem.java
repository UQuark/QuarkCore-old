package me.uquark.quarkcore.item;

import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractToolItem extends ToolItem {
    public final Identifier id;

    public AbstractToolItem(String modid, String name, ToolMaterial material, Settings settings) {
        super(material, settings);
        id = new Identifier(modid, name);
    }

    public void register() {
        Registry.register(Registry.ITEM, id, this);
    }
}
