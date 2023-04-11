package dbService;

import dbConverter.MaxProjectCountClient;

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

    public ResultSet getQueryResult(String path) {
        ResultSet resultSet;
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement();) {
            String maxProjectCountQueryStr = ReaderQuery.readQueryFromFile(path);
            resultSet = statement.executeQuery(maxProjectCountQueryStr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
