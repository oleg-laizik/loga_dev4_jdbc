package loga.dev4.jdbc.services;

import loga.dev4.jdbc.Database;
import loga.dev4.jdbc.dto.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static loga.dev4.jdbc.utils.UtilReader.getSQLQueryFromFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatabaseQueryService {

    private final Connection connection;

    public DatabaseQueryService() throws SQLException {
        connection = Database.getInstance().getConnection();
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            List<LongestProject> longestProjects = new ArrayList<>();
            ResultSet resultSet = executeQueryFromFile(statement, "sql/find_longest_project.sql");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int monthCount = resultSet.getInt("month_count");
                longestProjects.add(new LongestProject(name, monthCount));
            }
            return longestProjects;
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsCountClient() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
            ResultSet resultSet = executeQueryFromFile(statement, "sql/find_max_projects_client.sql");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
            }
            return maxProjectCountClients;
        }
    }

    public List<MaxSalaryWorker> findMaxSalary() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            List<MaxSalaryWorker> maxSalary = new ArrayList<>();
            ResultSet resultSet = executeQueryFromFile(statement, "sql/find_max_salary_worker.sql");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                maxSalary.add(new MaxSalaryWorker(name, salary));
            }
            return maxSalary;
        }
    }

    public List<ProjectPrices> findProjectPrices() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            List<ProjectPrices> projectPrices = new ArrayList<>();
            ResultSet resultSet = executeQueryFromFile(statement, "sql/print_project_prices.sql");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                projectPrices.add(new ProjectPrices(name, price));
            }
            return projectPrices;
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            List<YoungestEldestWorkers> youngestOldestWorkersList = new ArrayList<>();
            ResultSet resultSet = executeQueryFromFile(statement, "sql/find_youngest_eldest_workers.sql");
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                youngestOldestWorkersList.add(new YoungestEldestWorkers(type, name, birthday));
            }
            return youngestOldestWorkersList;
        }
    }

    private ResultSet executeQueryFromFile(Statement statement, String fileName) throws SQLException {
        String sql = getSQLQueryFromFile(fileName);
        return statement.executeQuery(sql);
    }
}