package me.macavitycode.qolmod;

import me.macavitycode.qolmod.block.ModBlocks;
import me.macavitycode.qolmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Qolmod implements ModInitializer {

    public static final String MOD_ID = "qolmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from " + MOD_ID);

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
