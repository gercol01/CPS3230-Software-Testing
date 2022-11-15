package scanpageobjects;

import Webscraper.Webscraper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mocks.search.*;

public class ScanSearchTests {
    Webscraper webscraper;
    ScanSearchPageObject searchPageObject;

    @BeforeEach
    public void setup(){
        webscraper = new Webscraper();
        searchPageObject = new ScanSearchPageObject();
    }

    @AfterEach
    public void teardown(){
        webscraper.quit();
    }

    //Searching for an object
    @Test
    public void manualSearchValidTest(){
        String result;

        //Setup
        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        //Exercise
        result = webscraper.searchScanObject(searchPageObject);

        //Verify
        Assertions.assertEquals("Correct title, successful search", result);
    }

    //Searching for an object
    @Test
    public void manualSearchInvalidTest(){
        String result;

        //Setup
        searchPageObject.setText("");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        //Exercise
        result = webscraper.searchScanObject(searchPageObject);

        //Verify
        Assertions.assertEquals("Incorrect title, unsuccessful search", result);
    }

    //Searching for an object
    @Test
    public void searchIncorrectSearchBarPathTest(){
        String result;

        //Setup
        searchPageObject.setText("MicrosoftLaptop");
        searchPageObject.setSearchBarPath("xyz");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");

        //Exercise
        result = webscraper.searchScanObject(searchPageObject);

        //Verify
        Assertions.assertEquals("could not find the search bar", result);
    }

    //Searching for an object
    @Test
    public void searchIncorrectSubmitButtonTest(){
        String result;

        //Setup
        searchPageObject.setText("MicrosoftLaptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("xyz");

        //Exercise
        result = webscraper.searchScanObject(searchPageObject);

        //Verify
        Assertions.assertEquals("could not find the submit button", result);
    }

    //Searching for an object
    @Test
    public void searchValidTest(){
        String result;

        //Setup
        SearchIsValid stub = new SearchIsValid();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("Correct title, successful search", result);
    }

    //Searching for an object
    @Test
    public void searchInvalidTest(){
        String result;

        //Setup
        SearchIsInvalid stub = new SearchIsInvalid();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("Incorrect title, unsuccessful search", result);
    }

    //Searching for an object
    @Test
    public void searchErrorTest(){
        String result;

        //Setup
        SearchError stub = new SearchError();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("error during search", result);
    }

    //Correct title
    @Test
    public void CorrectTitleTest(){
        String result;

        //Setup
        SearchCorrectTitle stub = new SearchCorrectTitle();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("Correct title, successful search", result);
    }

    //Incorrect title
    @Test
    public void IncorrectTitleTest(){
        String result;

        //Setup
        SearchIncorrectTitle stub = new SearchIncorrectTitle();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("Incorrect title, unsuccessful search", result);
    }

    //Could not find the search bar
    @Test
    public void searchCouldNotFindSearchBarTest(){
        String result;

        //Setup
        SearchCouldNotFindSearchBar stub = new SearchCouldNotFindSearchBar();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("could not find the search bar", result);
    }

    //Could not find the submit button
    @Test
    public void searchCouldNotFindSubmitButtonTest(){
        String result;

        //Setup
        SearchCouldNotFindSubmitButton stub = new SearchCouldNotFindSubmitButton();

        //Exercise
        result = webscraper.searchScanObject(stub);

        //Verify
        Assertions.assertEquals("could not find the submit button", result);
    }
}
