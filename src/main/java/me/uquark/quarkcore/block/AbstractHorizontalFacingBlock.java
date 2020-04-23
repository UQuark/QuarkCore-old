package me.uquark.quarkcore.block;

import me.uquark.quarkcore.base.AbstractMod;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class AbstractHorizontalFacingBlock extends HorizontalFacingBlock {
    public final Identifier id;
    public final BlockItem item;

    protected AbstractHorizontalFacingBlock(AbstractMod mod, String name, FabricBlockSettings blockSettings, Item.Settings itemSettings) {
        super(blockSettings.build());
        id = new Identifier(mod.modid, name);
        item = new BlockItem(this, itemSettings);
    }

    public void register() {
        Registry.register(Registry.BLOCK, id, this);
        Registry.register(Registry.ITEM, id, item);
    }
}
