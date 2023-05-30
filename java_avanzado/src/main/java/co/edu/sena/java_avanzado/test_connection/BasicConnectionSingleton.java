package co.edu.sena.java_avanzado.test_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicConnectionSingleton {
    private static String url = "jdbc:mysql://localhost:3306/java_project?serverTimezone=America/Bogota";
    private static String user = "cristian";
    private static String pass = "cristian";
    private static Connection conn;
    public static Connection getInstance()
            throws SQLException {
        if (conn == null) {
            conn =
                    DriverManager.getConnection(url, user,
                            pass);
        }
        return conn;
    }
} // BasicConnectionSingleton
