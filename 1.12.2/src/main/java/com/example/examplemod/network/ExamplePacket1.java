package com.example.examplemod.network;

import hohserg.elegant.networking.api.ClientToServerPacket;
import hohserg.elegant.networking.api.ElegantPacket;
import net.minecraft.entity.player.EntityPlayerMP;

@ElegantPacket
public class ExamplePacket1 implements ClientToServerPacket {
    final int keyCode;

    public ExamplePacket1(int keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public void onReceive(EntityPlayerMP player) {
        System.out.println("ExamplePacket1#onReceive keyCode: " + keyCode);
        new ExamplePacket2(player.world.rand.nextInt(10)).sendToPlayer(player);
    }
}
