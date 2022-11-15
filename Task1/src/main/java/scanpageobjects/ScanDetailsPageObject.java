package scanpageobjects;

import Scan.ScanProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScanDetailsPageObject {
    WebDriver driver;
    public ArrayList<String> listOfElements;
    public ArrayList<ScanProduct> listOfObjects;
    public ScanProduct scanProduct;

    public void setDriver(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void setListOfObjects(ArrayList<String> ListOfObjects){
        listOfElements = ListOfObjects;
    }

    public ArrayList<ScanProduct> getListOfObjects(){
        return listOfObjects;
    }

    public int getDetails(String webElement){
        ScanProduct object = new ScanProduct();

        //going to the link
        driver.get(webElement);

        int alertType = 6;
        object.setAlertType(6);

        try{
            WebElement Object = driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]/div/div[2]/div[1]/h1/span"));
            String title = Object.getText();
            title = title.replace("\"","");
            object.setTitle(title);
        }
        catch (NoSuchElementException e){
            return 1; //unsuccessful
        }

        try{
            WebElement Object = driver.findElement(By.xpath("//div[1]/img"));
            String imageUrl = Object.getAttribute("src");
            object.setImageUrl(imageUrl);
        }
        catch (NoSuchElementException e){
            return 2; //unsuccessful
        }

        try{
            WebElement Object = driver.findElement(By.className("value"));
            String description = Object.getText();
            object.setDesc(description);
        }
        catch (NoSuchElementException e){
            return 3; //unsuccessful
        }

        try{
            String currentUrl = driver.getCurrentUrl();
            object.setCurrentUrl(currentUrl);
        }
        catch (Exception e){
            return 4; //unsuccessful
        }

        try{
            String username = "1243555e-9957-4ff9-b13f-d3eec3f864ea";
            object.setUserName(username);
        }
        catch (Exception e){
            return 5; //unsuccessful
        }

        try{
            WebElement Object = driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]/div/div[2]/div[2]/div[1]/div[2]/span[1]"));
            String price = Object.getText();
            price = price.replace("€","");
            price = price.replace(".","");
            price = price.replace(",","");

            int price_in_cents;

            price_in_cents = Integer.parseInt(price);

            object.setPrice(price_in_cents);
        }
        catch (NoSuchElementException e){
            return 6; //unsuccessful
        }

        listOfObjects.add(object);
        return 0;//successful
    }

    public int scrapeResults(){
        int flag = 0;
        listOfObjects = new ArrayList<ScanProduct>();


        for(int i=0; i<listOfElements.size(); i++){
            flag = getDetails(listOfElements.get(i));
            if(flag != 0){
                break;
            }
        }

        if(flag == 0){
            return 0; //successful path
        }
        else if(flag == 1){
            return 1;
        }
        else if(flag == 2){
            return 2;
        }
        else if(flag == 3){
            return 3;
        }
        else if(flag == 4){
            return 4;
        }
        else if(flag == 5){
            return 5;
        }
        else if(flag == 6){
            return 6;
        }
        else{
            return -1;
        }

    }

}
