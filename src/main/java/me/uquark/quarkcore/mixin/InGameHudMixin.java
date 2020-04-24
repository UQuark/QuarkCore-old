package me.uquark.quarkcore.mixin;

import me.uquark.quarkcore.gui.AbstractHud;
import me.uquark.quarkcore.gui.HudManager;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin extends DrawableHelper {
    @Inject(method = "render", at = @At("HEAD"))
    public void render(float tickDelta, CallbackInfo info) {
        for (AbstractHud hud : HudManager.huds)
            hud.render();
    }
}
