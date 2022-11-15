package Webscraper;

import API.API;
import Scan.ScanProduct;
import org.openqa.selenium.WebElement;
import scanpageobjects.ScanDetailsPageObject;
import scanpageobjects.ScanProductListPageObject;
import scanpageobjects.ScanSearchPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Webscraper {
    public WebDriver driver;
    public String status;
    ArrayList<String> listOfObjects;
    ArrayList<ScanProduct> listOfObjectsAPI;


    //default constructor
    public Webscraper(){
        System.setProperty("webdriver.chrome.driver","/Users/User/webtesting/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void quit(){
        driver.quit();
    }

    public void setStatus(String Status){
        status = Status;
    }

    //search go to scan and search for an object
    public String searchScanObject(ScanSearchPageObject Search){
        //setting the same webdriver
        Search.setDriver(driver);

        //get search function and result
        int flag = Search.Search();

        if(flag==1){
            status = "Correct title, successful search";
            return status;
        }
        else if (flag==0){
            status = "Incorrect title, unsuccessful search";
            return status;
        }
        else if (flag==10){
            status = "could not find the search bar";
            return status;
        }
        else if (flag==110){
            status = "could not find the submit button";
            return status;
        }
        else{
            status = "error during search";
            return status;
        }
    }

    public String getResults(ScanProductListPageObject List){
        //setting the same webdriver
        List.setDriver(driver);

        if(status != null){
            //get the list
            int flag = List.getResults();


            if(flag==111){
                status = "Invalid product number";
                return status;
            }
            if(flag==11){
                listOfObjects = List.getListOfObjects();
                status = "successful collection of results";
                return status;
            }
            else if (flag==10){
                status = "unsuccessful, not all results were collected";
                return status;
            }
            else if(flag==0){
                status = "incorrect path";
                return status;
            }
            else{
                status = "error during search";
                return status;
            }
        }
        else{
            status = "search must be done before collecting results";
            return status;
        }
    }

    public String scrapeResults(ScanDetailsPageObject Details){
        //setting the same webdriver
        Details.setDriver(driver);
        Details.setListOfObjects(listOfObjects);



        //scraping the details of the results
        if(status != null){
            //get the list and scrape
            int flag = Details.scrapeResults();
            listOfObjectsAPI = Details.getListOfObjects();

            if(flag==0){
                status = "Successfully scraped all results";
                return status;
            }
            else if (flag==1){
                status = "title error";
                return status;
            }
            else if (flag==2){
                status = "imageUrl error";
                return status;
            }
            else if(flag==3){
                status = "description error";
                return status;
            }
            else if(flag==4){
                status = "URL error";
                return status;
            }
            else if(flag==5){
                status = "username error";
                return status;
            }
            else if(flag==6){
                status = "price error";
                return status;
            }
            else{
                status = "error during scraping";
                return status;
            }
        }
        else{
            status = "search & collect must be done before scraping results";
            return status;
        }
    }

    public String postAlerts(API api) throws Exception{
        api.setListOfObjects(listOfObjectsAPI);

        //scraping the details of the results
        if(status != null){
            //get the list and scrape
            int flag = api.postAlerts();

            if(flag==200){
                status = "Successful API POST";
                return status;
            }
            else if (flag==0){
                status = "Unsuccessful API POST";
                return status;
            }
            else{
                status = "Invalid API POST";
                return status;
            }
        }
        else{
            status = "search & collect must be done before scraping results";
            return status;
        }
    }
}
