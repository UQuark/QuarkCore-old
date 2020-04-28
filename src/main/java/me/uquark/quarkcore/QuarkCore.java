package me.uquark.quarkcore;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuarkCore implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    @SuppressWarnings("deprecation")
    public static final String gameDir = FabricLoader.INSTANCE.getGameDirectory().getAbsolutePath();

    public static String getModDir(String modName) {
        return gameDir + "/mods/" + modName + "/";
    }

    @Override
    public void onInitialize() {
    }
}
