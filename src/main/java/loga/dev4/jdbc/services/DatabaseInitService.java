package loga.dev4.jdbc.services;

import loga.dev4.jdbc.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        String initScriptPath = "sql/init_db.sql";

        try {
            String initScript = readScriptFromFile(initScriptPath);
            executeScript(initScript);
            System.out.println("Database initialized successfully.");
        } catch (IOException e) {
            System.err.println("Error reading init script file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error executing init script: " + e.getMessage());
        }
    }

    private static String readScriptFromFile(String filePath) throws IOException {
        StringBuilder scriptBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
        }
        return scriptBuilder.toString();
    }

    private static void executeScript(String script) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(script);
        }
    }
}