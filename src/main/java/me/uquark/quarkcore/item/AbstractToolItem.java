package me.uquark.quarkcore.item;

import me.uquark.quarkcore.base.AbstractMod;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractToolItem extends ToolItem {
    public final Identifier id;

    public AbstractToolItem(AbstractMod mod, ToolMaterial material, String name, Settings settings) {
        super(material, settings);
        id = new Identifier(mod.modid, name);
    }

    public void register() {
        Registry.register(Registry.ITEM, id, this);
    }
}
