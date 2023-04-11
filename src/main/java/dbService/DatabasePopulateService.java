package dbService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args){
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(ReaderQuery.readQueryFromFile("./src/main/java/sql/populate_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
