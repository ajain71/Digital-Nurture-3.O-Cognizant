import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CrawlerTask implements Runnable {
    private String url;
    private ConcurrentHashMap<String, String> crawledData;

    public CrawlerTask(String url, ConcurrentHashMap<String, String> crawledData) {
        this.url = url;
        this.crawledData = crawledData;
    }

    @Override
    public void run() {
        // Simulate crawling a web page
        String data = "Data from " + url;
        System.out.println("Crawling: " + url);
        try {
            Thread.sleep(1000); // Simulate time taken to crawl
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        crawledData.put(url, data);
    }
}

public class WebCrawler {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> crawledData = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] urls = {
                "https://example.com/page1",
                "https://example.com/page2",
                "https://example.com/page3",
                "https://example.com/page4",
                "https://example.com/page5"
        };

        for (String url : urls) {
            executorService.submit(new CrawlerTask(url, crawledData));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Crawling completed. Data collected:");
        crawledData.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
