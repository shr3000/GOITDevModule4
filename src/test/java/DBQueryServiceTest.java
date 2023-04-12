import dbConverter.LongestProject;
import dbConverter.MaxProjectCountClient;
import dbConverter.MaxSalaryWorker;
import dbConverter.OldestYoungestWorkers;
import dbService.DatabaseQueryService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class DBQueryServiceTest {
    @Test
    void findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        System.out.println("max project count clients = " + maxProjectCountClients);
    }

    @Test
    void findLongestProjectTest() throws SQLException {
        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProjec();
        System.out.println(longestProjects);
    }


    @Test
    void findMaxSalaryWorkerTest() throws SQLException{
        List<MaxSalaryWorker> workers = new DatabaseQueryService().findMaxSalaryWorker();
        System.out.println(workers);
    }
    @Test
    void findOldestYoungestWorkerTest() throws SQLException {
        List<OldestYoungestWorkers> workers = new DatabaseQueryService().findYoungestOldestWorkers();
        System.out.println(workers);
    }
}
