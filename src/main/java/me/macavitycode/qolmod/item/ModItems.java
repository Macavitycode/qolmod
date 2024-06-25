package me.macavitycode.qolmod.item;

import me.macavitycode.qolmod.Qolmod;
import me.macavitycode.qolmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Qolmod.MOD_ID, name), item);
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.RUBY))
            .displayName(Text.translatable("itemGroup.ruby"))
            .entries((context, entries) -> {
                entries.add(RUBY);
                entries.add(ModBlocks.RUBY_BLOCK);
            })
            .build();

    public static void registerModItems() {

        Registry.register(Registries.ITEM_GROUP, Identifier.of("qolmod", "ruby"), ITEM_GROUP);

        Qolmod.LOGGER.info("Registering Mod Items for " + Qolmod.MOD_ID);
    }
}
