package scanpageobjects;

import Webscraper.Webscraper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mocks.list.DidNotGetCorrectAmountOfResults;

public class ScanListTests {
    Webscraper webscraper;
    ScanSearchPageObject searchPageObject;
    ScanProductListPageObject listPageObject;

    @BeforeEach
    public void setup(){
        webscraper = new Webscraper();
        searchPageObject = new ScanSearchPageObject();
        listPageObject = new ScanProductListPageObject();
    }

    @AfterEach
    public void teardown(){
        webscraper.quit();
    }

    //Searching for an object
    @Test
    public void manualGet5ResultsTest(){
        String listResult;

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        webscraper.searchScanObject(searchPageObject);

        //Exercise
        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        listResult = webscraper.getResults(listPageObject);

        //Verify
        Assertions.assertEquals("successful collection of results", listResult);
    }

    //Searching for an object
    @Test
    public void manualIncorrectObjectPathTest1(){
        String listResult;

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        webscraper.searchScanObject(searchPageObject);

        //Exercise
        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("xyz");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        listResult = webscraper.getResults(listPageObject);

        //Verify
        Assertions.assertEquals("incorrect path", listResult);
    }

    //Searching for an object
    @Test
    public void manualIncorrectObjectPathTest2(){
        String listResult;

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        webscraper.searchScanObject(searchPageObject);

        //Exercise
        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\\\"maincontent\\\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("xyz");
        listResult = webscraper.getResults(listPageObject);

        //Verify
        Assertions.assertEquals("incorrect path", listResult);
    }

    //Invalid number of products
    @Test
    public void GetResultsBeforeSearchTest(){
        String listResult;

        //Setup

        //Exercise
        listPageObject.setNoProduct(5);
        listPageObject.setObjectPath1("//*[@id=\\\"maincontent\\\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("xyz");
        listResult = webscraper.getResults(listPageObject);

        //Verify
        Assertions.assertEquals("search must be done before collecting results", listResult);
    }

    //Invalid number of products
    @Test
    public void InvalidAmountOfProductsTest(){
        String listResult;

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        webscraper.searchScanObject(searchPageObject);

        //Exercise
        listPageObject.setNoProduct(0);
        listPageObject.setObjectPath1("//*[@id=\\\"maincontent\\\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        listResult = webscraper.getResults(listPageObject);

        //Verify
        Assertions.assertEquals("Invalid product number", listResult);
    }

    //Invalid number of products
    @Test
    public void DidNotGetCorrectAmountOfTest(){
        String listResult;

        //Setup
        webscraper.setStatus("Correct title, successful search");

        //Exercise
        DidNotGetCorrectAmountOfResults stub = new DidNotGetCorrectAmountOfResults();
        listResult = webscraper.getResults(stub);

        //Verify
        Assertions.assertEquals("unsuccessful, not all results were collected", listResult);
    }
}
