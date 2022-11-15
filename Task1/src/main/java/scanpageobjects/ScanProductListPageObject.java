package scanpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScanProductListPageObject {
    WebDriver driver;

    String objectPath1;
    String objectPath2;

    ArrayList<String> listOfObjects;
    int noOfProducts;

    public void setDriver(WebDriver webDriver){
        this.driver = webDriver;
        listOfObjects = new ArrayList<>();
    }

    public void setObjectPath1(String ObjectPath1){
        objectPath1 = ObjectPath1;
    }

    public void setObjectPath2(String ObjectPath2){
        objectPath2 = ObjectPath2;
    }

    //set number of products to visit
    public void setNoProduct(int NoOfProducts){
        noOfProducts = NoOfProducts;
    }

    public ArrayList<String> getListOfObjects(){
        return listOfObjects;
    }

    //return number of products to visit
    public int getNoOfProducts(){
        return noOfProducts;
    }

    public int getObject(int parameter){
        try{
            //Select the first object from he list "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li["+ parameter +"]/div/div[2]/strong/a"
            String Object = driver.findElement(By.xpath(objectPath1 + parameter + objectPath2)).getAttribute("href");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            listOfObjects.add(Object);
            return 1; //successful

        }catch (NoSuchElementException e){
            return 0; //unsuccessful
        }
    }

    public int getResults(){
        int flag = 0;

        if(noOfProducts<1){
            return 111;
        }
        else{
            for(int i=0; i< noOfProducts; i++){
                flag = getObject(i+1);
                if(flag == 0){
                    break;
                }
            }

            if(flag == 0){
                return 0; //unsuccessful path
            }
            else{
                if(listOfObjects.size() == noOfProducts){
                    return 11; //correct amount of objects collected
                }
                else{
                    return 10; //did not collect all the objects
                }
            }
        }
    }
}
