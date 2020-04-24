package me.uquark.quarkcore;

import me.uquark.quarkcore.data.DatabaseProvider;
import net.fabricmc.api.DedicatedServerModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class QuarkCoreServer implements DedicatedServerModInitializer {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitializeServer() {
        try {
            DatabaseProvider.startServer();
        } catch (SQLException e) {
            LOGGER.warn("Failed to launch QuarkCore DB Server");
            e.printStackTrace();
        }
    }
}
