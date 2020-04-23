package me.uquark.quarkcore.base;

import me.uquark.quarkcore.gui.AbstractHud;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMod {
    public static AbstractMod INSTANCE;
    public final String modid;
    public final List<AbstractHud> huds = new ArrayList<>();

    public AbstractMod(String modid) {
        this.modid = modid;
        INSTANCE = this;
    }
}
