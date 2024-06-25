package me.macavitycode.qolmod.block;

import me.macavitycode.qolmod.Qolmod;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import javax.tools.Tool;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(Block.Settings.create()
                    .strength(50.0f, 1200.0f)
                    .requiresTool()
                    .dropsNothing()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .pistonBehavior(PistonBehavior.BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Qolmod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(Qolmod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Qolmod.LOGGER.info("Registering Mod Blocks for " + Qolmod.MOD_ID);
    }
}
