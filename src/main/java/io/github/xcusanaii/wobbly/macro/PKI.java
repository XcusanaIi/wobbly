package io.github.xcusanaii.wobbly.macro;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class PKI {

    public static final PKI W = new PKI(Minecraft.getMinecraft().gameSettings.keyBindForward);
    public static final PKI JUMP = new PKI(Minecraft.getMinecraft().gameSettings.keyBindJump);

    public KeyBinding keyBind;

    public PKI(KeyBinding keyBind) {
        this.keyBind = keyBind;
    }
}
