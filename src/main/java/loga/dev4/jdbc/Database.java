package loga.dev4.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Slf4j
public class Database {

    public static final String DB_URL = "jdbc:mariadb://localhost:3306/myfirstdatabase";
    public static final String DB_USER = "myuser";
    public static final String DB_PASSWORD = "goitpass";

    private static Database instance;
    private Connection connection;

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                log.info("Database connected!");
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect to the database!", e);
            }
        }
        return connection;
    }
}
