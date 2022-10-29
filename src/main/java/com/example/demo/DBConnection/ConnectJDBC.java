package com.example.demo.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String userName = "root";
        String password = "64846";
        return getMySQLConnection(userName, password);
    }

    public static Connection getMySQLConnection(String userName, String password)
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://localhost:3306/demo";
        Connection conn = DriverManager.getConnection(connectionURL, userName,password);
        return conn;
    }
}
