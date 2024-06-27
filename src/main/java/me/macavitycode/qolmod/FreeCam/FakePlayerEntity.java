package me.macavitycode.qolmod.FreeCam;

import me.macavitycode.qolmod.QolmodClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

import java.util.Objects;

public class FakePlayerEntity extends OtherClientPlayerEntity {
    private final ClientPlayerEntity player = QolmodClient.client.player;
    private final ClientWorld world = QolmodClient.client.world;

    public FakePlayerEntity() {
        super(Objects.requireNonNull(QolmodClient.client.world), Objects.requireNonNull(QolmodClient.client.player).getGameProfile());

        copyPositionAndRotation(player);

        copyInventory();
        copyRotation();
        resetCapeMovement();

        spawn();
    }

    private void copyInventory() {
        getInventory().clone(player.getInventory());
    }

    private void copyRotation() {
        headYaw = player.headYaw;
        bodyYaw = player.bodyYaw;
    }

    private void resetCapeMovement() {
        capeX = getX();
        capeY = getY();
        capeZ = getZ();
    }

    private void spawn() {
        world.addEntity(this);
    }

    public void despawn() {
        discard();
    }

    public void resetPlayerPosition() {
        player.refreshPositionAndAngles(getX(), getY(), getZ(), getYaw(), getPitch());
    }
}
