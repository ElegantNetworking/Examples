package com.example.examplemod;

import com.example.examplemod.network.ExamplePacket1;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
    }

    private int[] keys = {
            Keyboard.KEY_1,
            Keyboard.KEY_2,
            Keyboard.KEY_3,
            Keyboard.KEY_4,
            Keyboard.KEY_5,
            Keyboard.KEY_6,
            Keyboard.KEY_7,
            Keyboard.KEY_8,
            Keyboard.KEY_9,
            Keyboard.KEY_0
    };

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        for (int key : keys)
            if (Keyboard.isKeyDown(key)) {
                new ExamplePacket1(key).sendToServer();
                return;
            }
    }
}
