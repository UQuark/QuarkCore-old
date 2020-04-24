package me.uquark.quarkcore.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AbstractBlock extends Block {
    public final Identifier id;
    public final BlockItem item;

    protected AbstractBlock(String modid, String name, FabricBlockSettings blockSettings, Item.Settings itemSettings) {
        super(blockSettings.build());
        id = new Identifier(modid, name);
        item = new BlockItem(this, itemSettings);
    }

    public void register() {
        Registry.register(Registry.BLOCK, id, this);
        Registry.register(Registry.ITEM, id, item);
    }
}
