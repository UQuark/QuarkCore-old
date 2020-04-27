package me.uquark.quarkcore.data;

import me.uquark.quarkcore.QuarkCore;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
    private static final String URL = "jdbc:h2:%s/mods/%s/%s";
    private static Server server;

    public static void startServer() throws SQLException {
        server = Server.createTcpServer("-tcpPort", "0").start();
    }

    public static void stopServer() {
        server.stop();
    }

    public static Connection getConnection(String modName, String dbName, String user, String pass) throws SQLException {
        return DriverManager.getConnection(String.format(URL, QuarkCore.gameDir, modName, dbName), user, pass);
    }
}
