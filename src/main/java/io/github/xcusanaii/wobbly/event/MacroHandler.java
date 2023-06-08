package io.github.xcusanaii.wobbly.event;

import io.github.xcusanaii.wobbly.macro.Macro;
import io.github.xcusanaii.wobbly.macro.Macros;
import io.github.xcusanaii.wobbly.macro.PKI;
import io.github.xcusanaii.wobbly.macro.atomic.Atomic;
import io.github.xcusanaii.wobbly.macro.atomic.PKIAtomic;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;

public class MacroHandler {

    private static Macro activatedMacro = null;
    private static final ArrayList<PKI> pkiBuffer = new ArrayList<PKI>();
    private static int tickI = 0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) return;
        for (Macro macro : Macros.macros) {
            if(macro.cd > 0){
                macro.cd--;
            }
        }
        if(activatedMacro == null){
            for (Macro macro : Macros.macros) {
                if(macro.cd == 0 && macro.keyBind.isPressed()){
                    onStartMacro(macro);
                    break;
                }
            }
        }
        clearPKIBuffer();
        if(activatedMacro != null){
            runMacro();
        }
    }

    public static void onStartMacro(Macro macro) {
        if(activatedMacro == null){
            activatedMacro = macro;
            tickI = 0;
            activatedMacro.cd = activatedMacro.coolDown;
        }
    }

    private static void runMacro() {
        for(Atomic atomic : activatedMacro.ticks.get(tickI)){
            atomic.run();
            if(atomic instanceof PKIAtomic){
                pkiBuffer.add(((PKIAtomic) atomic).pki);
            }
        }
        tickI++;
        if(tickI == activatedMacro.getLength()){
            if(activatedMacro.needForwardFix){
                pkiBuffer.clear();
            }
            activatedMacro = null;
        }
    }

    private static void clearPKIBuffer() {
        for(PKI pki : pkiBuffer){
            KeyBinding.setKeyBindState(pki.keyBind.getKeyCode(), false);
        }
        pkiBuffer.clear();
    }
}
