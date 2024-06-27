package me.macavitycode.qolmod.FreeCam;

import me.macavitycode.qolmod.QolmodClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Vec3d;

import com.mojang.authlib.GameProfile;

import java.util.UUID;

import static java.lang.String.format;


public class FreeCam {

    public static boolean enabled = false;

    private static FakePlayerEntity fakePlayer;

    public static float speedY = 0.5f;
    public static float speedXZ = 0.5f;

    public static void register() {
        QolmodClient.LOGGER.info("Hello from Freecam");
    }

    public static void onClientTick() {
        if (enabled && QolmodClient.client != null) {
            freeCamControl();
        } else {
            // TODO: Nothing
        }
    }

    static long handle;

    public static void toggle() {
        QolmodClient.LOGGER.warn("TOGGLED");
        enabled = !enabled;
        assert QolmodClient.client.player != null;
        if (enabled) {
            // On enable
            fakePlayer = new FakePlayerEntity();

            QolmodClient.client.player.setVelocity(Vec3d.ZERO);

            GameOptions opt = QolmodClient.client.options;
            KeyBinding[] bindings = {opt.forwardKey, opt.backKey, opt.leftKey,
                    opt.rightKey, opt.jumpKey, opt.sneakKey};

            for (KeyBinding binding : bindings) {
                handle = QolmodClient.client.getWindow().getHandle();
                binding.setPressed(InputUtil.isKeyPressed(handle, binding.getDefaultKey().getCode()));
            }
        } else {
            //On disable
            fakePlayer.resetPlayerPosition();
            fakePlayer.despawn();

            ClientPlayerEntity player = QolmodClient.client.player;
            player.setVelocity(Vec3d.ZERO);

            QolmodClient.client.worldRenderer.reload();
        }
    }

    private static void freeCamControl() {
        ClientPlayerEntity player = QolmodClient.client.player;
        assert player != null;
        player.setVelocity(Vec3d.ZERO);
        player.getAbilities().flying = false;

        player.setOnGround(false);
        Vec3d velocity = player.getVelocity();

        if (QolmodClient.client.options.jumpKey.isPressed())
            player.setVelocity(velocity.add(0, speedY, 0));

        if (QolmodClient.client.options.sneakKey.isPressed())
            player.setVelocity(velocity.subtract(0, speedY, 0));

        QolmodClient.LOGGER.error("Velocity is {}", format("%.16f", velocity.x));
    }

}

