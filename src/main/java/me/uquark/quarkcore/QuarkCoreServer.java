package me.uquark.quarkcore;

import me.uquark.quarkcore.data.DatabaseProvider;
import net.fabricmc.api.DedicatedServerModInitializer;

import java.sql.SQLException;

public class QuarkCoreServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        try {
            DatabaseProvider.startServer();
        } catch (SQLException e) {
            QuarkCore.LOGGER.warn("Failed to launch QuarkCore DB Server");
            e.printStackTrace();
        }
    }
}
