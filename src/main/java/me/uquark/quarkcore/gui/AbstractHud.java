package me.uquark.quarkcore.gui;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public abstract class AbstractHud extends DrawableHelper {
    public abstract void render(MatrixStack matrixStack);
}
