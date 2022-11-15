package scanpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ScanSearchPageObject {
    WebDriver driver;
    String text;
    ScanSearchPageObject runnerObject;
    String searchBarPath;
    String submitButtonPath;

    public void setDriver(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void setSearchBarPath(String SearchBarPath){
        searchBarPath = SearchBarPath;
    }

    public void setSubmitButtonPath(String SubmitButtonPath){
        submitButtonPath = SubmitButtonPath;
    }

    public void setText(String Text){
        this.text = Text;
    }

    public String getText(){
        return text;
    }

    //function to input search text for an object
    public int inputText(){
        try{
            //Search bar search "//*[@id=\"search\"]"
            WebElement searchField = driver.findElement(By.xpath(searchBarPath));
            searchField.sendKeys(text);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return 11;
        }catch (NoSuchElementException e){
            return 10;
        }
    }

    //function to press the submit button "//*[@id="search_mini_form"]/div[3]/button"
    public int submitSearchButton(){
        try{
            //Search bar search "//*[@id=\"search\"]"
            WebElement searchButton = driver.findElement(By.xpath(submitButtonPath));
            searchButton.submit();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //found submit button
            return 111;
        }catch (NoSuchElementException e){
            //could not find the submit button
            return 110;
        }
    }

    public int getTitle(){
        if (driver.getTitle().equals("Search results for: '" + text + "' | SCAN")) {
            return 1;
        }
        //if it is a invalid title
        else if (driver.getTitle().equals("Computers Store Malta | SCAN")) {
            return 0;
        }
        //if it is neither
        else {
            return -1;
        }
    }

    public int Search(){
        //Go to scan.com
        driver.get("https://www.scanmalta.com/shop/");

        // input the text
        int inputResult = inputText();

        //could not find the search bar
        if(inputResult == 10){
            return inputResult;
        }
        else{
            //pressing the submit button
            int submitResult = submitSearchButton();

            if(submitResult == 110){
                return submitResult;
            }
            else {
                int Title = getTitle();

                //if the title is valid
                if (Title == 1) {
                    return Title;
                }
                //if it is a invalid title
                else if (Title == 0) {
                    return 0;
                }
                //if it is neither
                else {
                    return -1;
                }
            }
        }
    }
}
