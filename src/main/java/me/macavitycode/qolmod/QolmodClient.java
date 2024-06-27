package me.macavitycode.qolmod;

import me.macavitycode.qolmod.FreeCam.FreeCam;
import me.macavitycode.qolmod.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QolmodClient implements ClientModInitializer {

    public static final String MOD_ID = "qolmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        FreeCam.register();

        ClientTickEvents.START_CLIENT_TICK.register(client ->  {
            FreeCam.onClientTick();
        });
    }
}

