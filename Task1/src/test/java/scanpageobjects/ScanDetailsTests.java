package scanpageobjects;

import Webscraper.Webscraper;
import mocks.details.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScanDetailsTests {
    Webscraper webscraper;
    ScanSearchPageObject searchPageObject;
    ScanProductListPageObject listPageObject;
    ScanDetailsPageObject detailsPageObject;

    @BeforeEach
    public void setup(){
        webscraper = new Webscraper();
        searchPageObject = new ScanSearchPageObject();
        listPageObject = new ScanProductListPageObject();
        detailsPageObject = new ScanDetailsPageObject();
    }

    @AfterEach
    public void teardown(){
        webscraper.quit();
    }

    //Scraping5Objects
    @Test
    public void manualScrape5ResultsTest(){
        String detailsResult;

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(detailsPageObject);

        //Verify
        Assertions.assertEquals("Successfully scraped all results", detailsResult);
    }

    @Test
    public void DescriptionErrorTest(){
        String detailsResult;
        DescriptionError stub = new DescriptionError();

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(stub);

        //Verify
        Assertions.assertEquals("description error", detailsResult);
    }

    @Test
    public void ImageErrorTest(){
        String detailsResult;
        ImageError stub = new ImageError();

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(stub);

        //Verify
        Assertions.assertEquals("imageUrl error", detailsResult);
    }

    @Test
    public void PriceErrorTest(){
        String detailsResult;
        PriceError stub = new PriceError();

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(stub);

        //Verify
        Assertions.assertEquals("price error", detailsResult);
    }

    @Test
    public void TitleErrorTest(){
        String detailsResult;
        TitleError stub = new TitleError();

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(stub);

        //Verify
        Assertions.assertEquals("title error", detailsResult);
    }

    @Test
    public void URLErrorTest(){
        String detailsResult;
        URLError stub = new URLError();

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(stub);

        //Verify
        Assertions.assertEquals("URL error", detailsResult);
    }

    @Test
    public void UsernameErrorTest(){
        String detailsResult;
        UsernameError stub = new UsernameError();

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        //Exercise
        detailsResult = webscraper.scrapeResults(stub);

        //Verify
        Assertions.assertEquals("username error", detailsResult);
    }
}
