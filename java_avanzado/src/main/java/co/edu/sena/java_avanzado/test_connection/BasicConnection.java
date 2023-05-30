package co.edu.sena.java_avanzado.test_connection;

import java.sql.*;

public class BasicConnection { //CLase probar conectividad
        public static void main(String[] args)
        {
            String url = "jdbc:mysql://localhost:3306/java_project?serve rTimezone=America/Bogota";
            String username = "cristian";
            String password = "cristian";
            String sql = null;
            Connection conn = null;
            Statement stm = null;
            ResultSet rs = null;
            try {
                sql = "SELECT * FROM java_project.users_tbl";
                conn = DriverManager.getConnection(url, username, password);
                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    System.out.print(rs.getString("user_firstname"));
                            System.out.print(" | ");

                    System.out.println(rs.getString("user_lastname"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    rs.close();
                    stm.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }// end try-catch
        } // main
} // BasicConnection