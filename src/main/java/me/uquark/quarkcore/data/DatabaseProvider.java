package me.uquark.quarkcore.data;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
    private static final String URL = "jdbc:h2:./";
    private static Server server;

    public static void startServer() throws SQLException {
        server = Server.createTcpServer("-tcpPort", "0").start();
    }

    public static void stopServer() {
        server.stop();
    }

    public static Connection getConnection(String dbName, String user, String pass) throws SQLException {
        return DriverManager.getConnection(URL + dbName, user, pass);
    }
}
