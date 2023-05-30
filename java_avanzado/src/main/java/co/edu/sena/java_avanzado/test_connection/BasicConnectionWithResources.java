package co.edu.sena.java_avanzado.test_connection;

import java.sql.*;

public class BasicConnectionWithResources {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java_project?serve rTimezone=America/Bogota";
        String username = "cristian";
        String password = "cristian";
        String sql = "SELECT * FROM java_project.users_tbl";
        try (Connection conn =
                     DriverManager.getConnection(url,
                             username, password);
             Statement stmt =
                     conn.createStatement();
             ResultSet rs =
                     stmt.executeQuery(sql)) {
            while (rs.next()) {

                System.out.println(rs.getString("user_firstname"));

                        System.out.println(rs.getString("user_lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // end try-catch
    } // main
} // BasicConnectionWithResources

