package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/telefonos";
        String user = "appuser";
        String password = "apppass";

        // SQL Query
        String sql = "SELECT * FROM users";

        // Use try-with-resources to auto-close resources
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Process the results
            while (rs.next()) {
                // Replace with actual column names or indices
                int id = rs.getInt("id");
                String name = rs.getString("first_name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}