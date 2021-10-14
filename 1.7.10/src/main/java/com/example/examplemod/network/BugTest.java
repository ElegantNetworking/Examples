package com.example.examplemod.network;

import hohserg.elegant.networking.api.ClientToServerPacket;
import hohserg.elegant.networking.api.ElegantPacket;
import net.minecraft.entity.player.EntityPlayerMP;

@ElegantPacket
public class BugTest implements ClientToServerPacket {

    public final String name;

    public BugTest(String name) {
        this.name = name;
    }

    public void onReceive(EntityPlayerMP player){
        System.out.println("BugTest#onReceive "+name);
    }
}