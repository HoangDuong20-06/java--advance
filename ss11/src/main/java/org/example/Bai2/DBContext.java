package org.example.Bai2;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/pharmacy_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}