package com.epam.racecup.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@PropertySource("application.properties")
public class DatabaseConnection {
    @Value("${spring.datasource.driver-class-name}")
    private static String DATABASE_DRIVER;
    @Value("${spring.datasource.url}")
    private static String DATABASE_URL;
    @Value("${spring.datasource.username}")
    private static final String USERNAME = "capstone";
    @Value("${spring.datasource.password}")
    private static final String PASSWORD = "project";

    public static org.apache.log4j.Logger logger = Logger.getLogger(DatabaseConnection.class);

    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            logger.info("Connection to database has been created");
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Connection to database ERROR! " + e.getMessage());
        }

        return connection;
    }
}
