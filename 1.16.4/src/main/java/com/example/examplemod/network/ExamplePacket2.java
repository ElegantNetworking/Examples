package com.example.examplemod.network;

import hohserg.elegant.networking.api.ElegantPacket;
import hohserg.elegant.networking.api.ServerToClientPacket;
import net.minecraft.client.Minecraft;

@ElegantPacket
public class ExamplePacket2 implements ServerToClientPacket {
    final int randomInt;

    public ExamplePacket2(int randomInt) {

        this.randomInt = randomInt;
    }

    @Override
    public void onReceive(Minecraft mc) {
        System.out.println("ExamplePacket2#onReceive randomInt: " + randomInt);
    }
}
