package me.macavitycode.qolmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Qolmod implements ModInitializer {

    public static final String MOD_ID = "qolmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("\nHello from qolmmod\n");
    }
}
