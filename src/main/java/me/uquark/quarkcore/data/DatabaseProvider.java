package me.uquark.quarkcore.data;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
    private static final String URL = "jdbc:h2:./quarkcore_db";
    private static final String USER = "quarkcore";
    private static final String PASS = "quarkcore";
    private static Server server;

    public static void startServer() throws SQLException {
        server = Server.createTcpServer("-tcpPort", "0").start();
    }

    public static void stopServer() {
        server.stop();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
