import dbConverter.*;
import dbService.DatabaseInitService;
import dbService.DatabaseQueryService;
import dbService.ReaderQuery;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class DBQueryServiceTest {

    @Test
    void readerQueryTest() {
        System.out.println(ReaderQuery.readQueryFromFile("./src/main/java/sql/init_db.sql"));
    }
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

    @Test
    void printProjectPriceTest() throws SQLException {
        List<ProjectPrice> prices = new DatabaseQueryService().printProjectPrices();
        System.out.println(prices);
    }
}
