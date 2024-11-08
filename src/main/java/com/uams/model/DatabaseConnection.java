package com.uams.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/user_access_management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Test@123";

    public static Connection getConnection() throws SQLException {
        try {
            // Ensure the JDBC driver is loaded
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found", e);
        }
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
