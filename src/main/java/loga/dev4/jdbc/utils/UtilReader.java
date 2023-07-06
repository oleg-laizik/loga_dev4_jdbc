package loga.dev4.jdbc.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
public class UtilReader {

    public static String getSQLQueryFromFile(String fileName) {
        String filePath;
        try {
            filePath = getFilePath(fileName);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to get file path: " + fileName, e);
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line.trim()).append(" ");
            }
            System.out.println("Query successfully retrieved from file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private static String getFilePath(String fileName) throws URISyntaxException {
        ClassLoader classLoader = UtilReader.class.getClassLoader();
        Path path = Paths.get(Objects.requireNonNull(classLoader.getResource(fileName)).toURI());
        return path.toString();
    }
}