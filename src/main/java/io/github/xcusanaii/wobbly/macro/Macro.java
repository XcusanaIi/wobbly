package io.github.xcusanaii.wobbly.macro;

import io.github.xcusanaii.wobbly.macro.atomic.Atomic;
import net.minecraft.client.settings.KeyBinding;

import java.util.ArrayList;

public class Macro {

    public final ArrayList<ArrayList<Atomic>> ticks;
    public final KeyBinding keyBind;
    public final boolean needForwardFix;
    public final int coolDown;
    public int cd;

    public Macro(ArrayList<ArrayList<Atomic>> ticks, KeyBinding keyBind, boolean needForwardFix, int coolDown, int cd) {
        this.ticks = ticks;
        this.keyBind = keyBind;
        this.needForwardFix = needForwardFix;
        this.coolDown = coolDown;
        this.cd = cd;
    }

    public int getLength() {
        return ticks.size();
    }
}
