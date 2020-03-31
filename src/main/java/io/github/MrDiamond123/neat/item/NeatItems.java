package io.github.MrDiamond123.neat.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NeatItems {
    public static final Item DIAMOND_SHARDS;
    public static final Item PLAYER_PEARL;
    private static Item register(Block block) {
        return register(new BlockItem(block, new Item.Settings()));
    }

    private static Item register(Block block, ItemGroup group) {
        return register(new BlockItem(block, (new Item.Settings()).group(group)));
    }

    private static Item register(BlockItem item) {
        return register((Block)item.getBlock(), (Item)item);
    }

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return register(new Identifier("diamondsneat", id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item)Registry.register(Registry.ITEM, (Identifier)id, item);
    }


static {
        DIAMOND_SHARDS = register("diamond_shards", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
        PLAYER_PEARL = register("player_pearl", new PlayerPearlItem(new Item.Settings().group(ItemGroup.MISC)));
    }
}
