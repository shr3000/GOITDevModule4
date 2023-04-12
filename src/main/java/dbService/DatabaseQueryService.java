package dbService;

import dbConverter.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient>maxProjectCountClients = new ArrayList<>();
        ResultSet result = getQueryResult("./src/main/java/sql/find_max_projects_client.sql");
        while (result.next()){
            MaxProjectCountClient client = new MaxProjectCountClient();
            client.setProjectCount(result.getInt("clnt"));
            client.setName(result.getString("name"));
            maxProjectCountClients.add(client);
        }
        return maxProjectCountClients;
    }

    public List<LongestProject> findLongestProjec() {
        List<LongestProject> longestProjects = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = getQueryResult("./src/main/java/sql/find_longest_project.sql");
            while (resultSet.next()){
                LongestProject project = new LongestProject();
                project.setMonthCount(resultSet.getInt("month_count"));
                project.setName(resultSet.getString("name"));
                longestProjects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return longestProjects;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> workers = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = getQueryResult("./src/main/java/sql/find_max_salary_worker.sql");
            while (resultSet.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker();
                worker.setName(resultSet.getString("name"));
                worker.setSalary(resultSet.getDouble("salary"));
                workers.add(worker);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return workers;
    }

    public List<OldestYoungestWorkers> findYoungestOldestWorkers(){
        List<OldestYoungestWorkers> workers = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = getQueryResult("./src/main/java/sql/find_youngest_eldest_workers.sql");
            while (resultSet.next()) {
                OldestYoungestWorkers worker = new OldestYoungestWorkers();
                worker.setName(resultSet.getString("name"));
                worker.setType(resultSet.getString("type"));
                worker.setBirtday(resultSet.getString("birthday"));
                workers.add(worker);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workers;
    }

    public List<ProjectPrice> printProjectPrices(){
        List<ProjectPrice> projectPrices = new ArrayList<>();
        return projectPrices;
    }

    private ResultSet getQueryResult(String path) throws SQLException {
        ResultSet resultSet;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
            String maxProjectCountQueryStr = ReaderQuery.readQueryFromFile(path);
            resultSet = statement.executeQuery(maxProjectCountQueryStr);

        return resultSet;
    }

}
