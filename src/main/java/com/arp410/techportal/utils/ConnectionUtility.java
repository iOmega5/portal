package com.arp410.techportal.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/techportaldb",
                            "root", "root");
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ignored) {
        }
    }
}