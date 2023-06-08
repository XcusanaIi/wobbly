package io.github.xcusanaii.wobbly;

import io.github.xcusanaii.wobbly.event.MacroHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = Wobbly.MODID, version = Wobbly.VERSION)
public class Wobbly {
    public static final String MODID = "wobbly";
    public static final String VERSION = "0.0.1";
    public static final Logger LOGGER = FMLLog.getLogger();

    public static final String CATEGORY = "category.wobbly";

    public static final KeyBinding keyHH = new KeyBinding("key.hh", Keyboard.KEY_NONE, CATEGORY);
    public static final KeyBinding keyJam = new KeyBinding("key.jam", Keyboard.KEY_NONE, CATEGORY);

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(keyHH);
        ClientRegistry.registerKeyBinding(keyJam);

        MinecraftForge.EVENT_BUS.register(new MacroHandler());
    }
}
