import dbConverter.MaxProjectCountClient;
import dbService.DatabaseQueryService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class DBQueryServiceTest {
    @Test
    void findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        System.out.println("maxProjectCountClients = " + maxProjectCountClients);
    }
}
