import java.util.stream.Stream;

public class AggregationTest {
    SomeService someService = new SomeService();

    public static void main(String[] args) {
        AggregationTest test = new AggregationTest();
        test.doTheNeedFull2();
    }

    // Rough structure of your pagination code
    public void doTheNeedFull() {
        int page = 1;
        int pageSize = 500;
        SomeDTO result = someService.getResult(page, pageSize);
        boolean hasMoreResults = true;


        while (hasMoreResults) {
            processResult(result);
            hasMoreResults = hasMoreResults(result);
            if (hasMoreResults) {
                page++;
                result = someService.getResult(page, pageSize);
            }
        }
    }

    // rough stream version of it
    public void doTheNeedFull2() {
        int pageSize = 500;
        int initialPage = 1;
        Stream.iterate(initialPage, page -> page + 1) // Generate a lazy infinite stream of page numbers starting from 1 and incrementing by 1
                .map(page -> fetchAndProcessPage(page, pageSize)) // Fetch and process each page, return boolean which determines if there is more to fetch
                .takeWhile(hasMoreResults -> hasMoreResults) // Continue while there are more results
                .forEach(x -> {
                }); // Terminal operation to trigger the stream

    }

    public boolean fetchAndProcessPage(int page, int pageSize) {
        SomeDTO result = someService.getResult(page, pageSize);
        processResult(result);
        return hasMoreResults(result);
    }

    private boolean hasMoreResults(SomeDTO result) {
        return result.recordsOnThisPage == result.pageSize; // Page is full
    }

    private void processResult(SomeDTO result) {
        System.out.println("Processing page: " + result.page + " with pageSize: " + result.pageSize + " having records: " + result.recordsOnThisPage);
        // Doesn't matter so much but I guess your cache logic
    }

    public class SomeService {
        // Simulation of the service
        int totalRecords = 1200; // for simulation

        public SomeDTO getResult(int page, int pageSize) {
            System.out.println("Getting page " + page);
            SomeDTO result = new SomeDTO();
            result.page = page;
            result.pageSize = pageSize;
            int startRecord = (page - 1) * pageSize;
            if (startRecord >= totalRecords) {
                result.recordsOnThisPage = 0; // No more records
            } else if (startRecord + pageSize > totalRecords) {
                result.recordsOnThisPage = totalRecords - startRecord; // Last page with remaining records
            } else {
                result.recordsOnThisPage = pageSize; // Full page
            }
            return result;
        }
    }

    public class SomeDTO {
        int page;
        int pageSize;
        int recordsOnThisPage; // just didn't feel like making a list. You can do list.size on the real dto
    }
}
