package com.weather.weather.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {
    public static Connection getDBConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3308/weather-service","user","password");
        } catch (SQLException e) {
            return null;
        }
    }
}
