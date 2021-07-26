package com.example.examplemod;

import com.example.examplemod.network.ExamplePacket1;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
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
