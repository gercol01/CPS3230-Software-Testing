package API;

import Webscraper.Webscraper;
import mocks.api.Return0;
import mocks.api.Return200;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scanpageobjects.ScanDetailsPageObject;
import scanpageobjects.ScanProductListPageObject;
import scanpageobjects.ScanSearchPageObject;

public class APITests {
    Webscraper webscraper;
    ScanSearchPageObject searchPageObject;
    ScanProductListPageObject listPageObject;
    ScanDetailsPageObject detailsPageObject;
    API api;

    @BeforeEach
    public void setup(){
        webscraper = new Webscraper();
        searchPageObject = new ScanSearchPageObject();
        listPageObject = new ScanProductListPageObject();
        detailsPageObject = new ScanDetailsPageObject();
        api = new API();
    }

    @AfterEach
    public void teardown(){
        webscraper.quit();
    }

    //Posting5Objects
    @Test
    public void manualPOST5ResultsTest() throws Exception {
        String APIResult;

        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        webscraper.scrapeResults(detailsPageObject);

        APIResult = webscraper.postAlerts(api);

        //Verify
        Assertions.assertEquals("Successful API POST", APIResult);
    }

    //Posting5Objects
    @Test
    public void unsuccessfulPOSTTest() throws Exception {
        String APIResult;

        Return0 stub = new Return0();

        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        webscraper.scrapeResults(detailsPageObject);

        APIResult = webscraper.postAlerts(stub);

        //Verify
        Assertions.assertEquals("Unsuccessful API POST", APIResult);
    }

    //Posting5Objects
    @Test
    public void successfulPOSTTest() throws Exception {
        String APIResult;

        Return200 stub = new Return200();

        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        webscraper.scrapeResults(detailsPageObject);

        APIResult = webscraper.postAlerts(stub);

        //Verify
        Assertions.assertEquals("Successful API POST", APIResult);
    }


}
