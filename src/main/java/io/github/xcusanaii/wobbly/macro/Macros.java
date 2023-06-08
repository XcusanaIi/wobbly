package io.github.xcusanaii.wobbly.macro;

import io.github.xcusanaii.wobbly.Wobbly;
import io.github.xcusanaii.wobbly.macro.atomic.Atomic;
import io.github.xcusanaii.wobbly.macro.atomic.PKIAtomic;

import java.util.ArrayList;
import java.util.List;

public class Macros {
    public static final Macro HH_TIMING = new Macro(new ArrayList<ArrayList<Atomic>>() {
        {
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);add(PKIAtomic.JUMP);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
        }
    }, Wobbly.keyHH, true, 4, 0);

    public static final Macro JAM_TIMING = new Macro(new ArrayList<ArrayList<Atomic>>() {
        {
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);add(PKIAtomic.JUMP);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
            add(new ArrayList<Atomic>() {
                {
                    add(PKIAtomic.W);
                }
            });
        }
    }, Wobbly.keyJam, true, 4, 0);

    public static final List<Macro> macros = new ArrayList<Macro>();

    static {
        macros.add(HH_TIMING);
        macros.add(JAM_TIMING);
    }
}
