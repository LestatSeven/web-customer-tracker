package com.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String driverClass;
    private final String URL;
    private final String user;
    private final String pass;
    private Connection connection;

    public DBConnection(String driverClass, String URL, String user, String pass) {
        this.driverClass = driverClass;
        this.URL = URL;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (this.connection != null) {
            return connection;
        }

        System.out.println("Creating DB Connection");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(URL, user, pass);
        System.out.println("Successfully Created DB Connection");
        this.connection = connection;
        return connection;
    }

    public void close() {
        System.out.println("DBConnection close called");
        if (this.connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
