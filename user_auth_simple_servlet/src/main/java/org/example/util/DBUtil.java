package org.example.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    public static final String url = "jdbc:postgresql://localhost:5432/testdb";
    public static final String username = "zeshan22";
    public static final String password = "123456";

    static {
        try {
            // register driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Connection getConnection() throws SQLException {
        // establish connection
        return DriverManager.getConnection(url, username, password);
    }
}
