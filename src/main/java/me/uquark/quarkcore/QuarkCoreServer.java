package me.uquark.quarkcore;

import me.uquark.quarkcore.data.DatabaseProvider;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

import java.sql.SQLException;

public class QuarkCoreServer implements DedicatedServerModInitializer, ServerLifecycleEvents.ServerStopping {
    @Override
    public void onInitializeServer() {
        ServerLifecycleEvents.SERVER_STOPPING.register(this);
        try {
            DatabaseProvider.startServer();
            QuarkCore.LOGGER.info("QuarkCore DB Server started");
        } catch (SQLException e) {
            QuarkCore.LOGGER.warn("Failed to launch QuarkCore DB Server");
            e.printStackTrace();
        }
    }

    @Override
    public void onServerStopping(MinecraftServer minecraftServer) {
        DatabaseProvider.stopServer();
        QuarkCore.LOGGER.info("QuarkCore DB Server stopped");
    }
}
