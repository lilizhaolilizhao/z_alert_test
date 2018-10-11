package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * MySQL工具
 */
public class MySQL extends DataBase {
    private final String hostname;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    private static boolean dev = true;

    public MySQL(String hostname, String database, String username, String password) {
        this(hostname, 3306, database, username, password);
    }

    public MySQL(String hostname, int port, String database, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection open() throws Exception {
        if (check())
            return connection;

        String connectionURL = "jdbc:mysql://" + this.hostname + ":" + this.port;
        if (database != null)
            connectionURL += "/" + this.database;
        connectionURL += "?useSSL=false";
        if (dev)
            connectionURL += "&verifyServerCertificate=false&characterEncoding=utf-8";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionURL, this.username, this.password);

        return connection;
    }

}