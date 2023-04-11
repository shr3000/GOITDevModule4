package dbService;

import dbService.Database;
import dbService.ReaderQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(ReaderQuery.readQueryFromFile("./src/main/java/sql/init_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
