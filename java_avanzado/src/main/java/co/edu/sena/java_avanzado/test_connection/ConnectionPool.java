package co.edu.sena.java_avanzado.test_connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static String url =
            "jdbc:mysql://localhost:3306/java_project?serverTimezone=America/Bogota";
    private static String user = "cristian";
    private static String pass = "cristian";
    private static BasicDataSource pool;
    public static BasicDataSource
    getInstance() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);
            pool.setInitialSize(5);
            pool.setMinIdle(5);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }
    public static Connection getConnection()
            throws SQLException {
        return getInstance().getConnection();
    }
} // ConnectionPool
