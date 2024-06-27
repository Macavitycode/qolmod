package me.macavitycode.qolmod.event;

import me.macavitycode.qolmod.FreeCam.FreeCam;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY = "key.category.qolmod";

    public static final String KEY_TOGGLE_FREECAM = "key.qolmod.togglefreecam";

    public static KeyBinding toggleFreeCam;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleFreeCam.wasPressed()) {
                FreeCam.toggle();
            }
        });
    }

    public static void register() {

        toggleFreeCam = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TOGGLE_FREECAM,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_COMMA,
                KEY_CATEGORY
        ));
        registerKeyInputs();
    }


}
