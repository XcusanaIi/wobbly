package io.github.xcusanaii.wobbly.macro.atomic;

import io.github.xcusanaii.wobbly.macro.PKI;
import net.minecraft.client.settings.KeyBinding;

public class PKIAtomic implements Atomic{

    public static final PKIAtomic W = new PKIAtomic(PKI.W);
    public static final PKIAtomic JUMP = new PKIAtomic(PKI.JUMP);

    public final PKI pki;

    public PKIAtomic(PKI pki) {
        this.pki = pki;
    }

    @Override
    public void run() {
        KeyBinding.setKeyBindState(pki.keyBind.getKeyCode(), true);
    }
}
