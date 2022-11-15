package Alert;

import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Alert{
    public boolean iconFlag = false;
    public boolean headingFlag = false;
    public boolean descriptionFlag = false;
    public boolean imageFlag = false;
    public boolean priceFlag = false;
    public boolean linkFlag = false;
    public int counter = 0;

    public String temp; //temporary value holder
    public int tempType; //temporary icon type

    public WebDriver driver;

    public Alert(WebDriver Driver){
        this.driver = Driver;
    }

    public void Create1Alert(int Type) throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body;
        Request request;
        Response response;

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\":" + Type + ",\r\n    \"heading\": \"Jumper Windows 11 Laptop\",\r\n    \"description\": \"Jumper Windows 11 Laptop 1080P Display, 12GB RAM 256GB SSD\",\r\n    \"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\":24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
    }

    public void Create3Alerts() throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body;
        Request request;
        Response response;

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 6,\r\n    \"heading\": \"Jumper Windows 11 Laptop\",\r\n    \"description\": \"Jumper Windows 11 Laptop 1080P Display, 12GB RAM 256GB SSD\",\r\n    \"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 5,\r\n    \"heading\": \"Cars 3 Toy\",\r\n    \"description\": \"A red and yellow Cars 2 Toy, perfect for kids of all ages\",\r\n    \"url\": \"https://www.amazon.com/Characters-Lightning-McQueen-Friends-die-cast/dp/B097Y46JMV/ref=sr_1_3?crid=5CRHCG22ZPSV&keywords=cars+2+toy&qid=1668364576&sprefix=cars+2+toy%2Caps%2C266&sr=8-3\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/81qGyJZHHmL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 3388\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 5,\r\n    \"heading\": \"Marvel Comics: Spider-man 1:7 Scale Bust\",\r\n    \"description\": \"Shows off Spidey's trademark spider-sense. Stands approximately 6 tall.\",\r\n    \"url\": \"https://a.co/d/5kBapFM\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/71PzWu9IzcL._AC_SY879_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        response = client.newCall(request).execute();
    }

    //create more than 5 alerts, hence 6
    public void Create6Alerts() throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body;
        Request request;
        Response response;

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 6,\r\n    \"heading\": \"Jumper Windows 11 Laptop\",\r\n    \"description\": \"Jumper Windows 11 Laptop 1080P Display, 12GB RAM 256GB SSD\",\r\n    \"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 6,\r\n    \"heading\": \"Jumper Windows 11 Laptop\",\r\n    \"description\": \"Jumper Windows 11 Laptop 1080P Display, 12GB RAM 256GB SSD\",\r\n    \"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 5,\r\n    \"heading\": \"Cars 3 Toy\",\r\n    \"description\": \"A red and yellow Cars 2 Toy, perfect for kids of all ages\",\r\n    \"url\": \"https://www.amazon.com/Characters-Lightning-McQueen-Friends-die-cast/dp/B097Y46JMV/ref=sr_1_3?crid=5CRHCG22ZPSV&keywords=cars+2+toy&qid=1668364576&sprefix=cars+2+toy%2Caps%2C266&sr=8-3\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/81qGyJZHHmL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 3388\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 5,\r\n    \"heading\": \"Marvel Comics: Spider-man 1:7 Scale Bust\",\r\n    \"description\": \"Shows off Spidey's trademark spider-sense. Stands approximately 6 tall.\",\r\n    \"url\": \"https://a.co/d/5kBapFM\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/71PzWu9IzcL._AC_SY879_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 6,\r\n    \"heading\": \"Jumper Windows 11 Laptop\",\r\n    \"description\": \"Jumper Windows 11 Laptop 1080P Display, 12GB RAM 256GB SSD\",\r\n    \"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();

        body = RequestBody.create(mediaType, "{\r\n    \"alertType\": 6,\r\n    \"heading\": \"Jumper Windows 11 Laptop\",\r\n    \"description\": \"Jumper Windows 11 Laptop 1080P Display, 12GB RAM 256GB SSD\",\r\n    \"url\": \"https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth\",\r\n    \"imageUrl\": \"https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg\",\r\n    \"postedBy\": \"1243555e-9957-4ff9-b13f-d3eec3f864ea\",\r\n    \"priceInCents\": 24999\r\n}");
        request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        response = client.newCall(request).execute();
    }

    public void get3Icons(){


        ArrayList<WebElement> iconList = new ArrayList<>();

        WebElement icon1 = driver.findElement(By.xpath("/html/body/div/main/table[1]/tbody/tr[1]/td/h4/img"));
        iconList.add(icon1);

        WebElement icon2 = driver.findElement(By.xpath("/html/body/div/main/table[2]/tbody/tr[1]/td/h4/img"));
        iconList.add(icon2);

        WebElement icon3 = driver.findElement(By.xpath("/html/body/div/main/table[3]/tbody/tr[1]/td/h4/img"));
        iconList.add(icon3);

        //if there are 3 icons
        if(iconList.size()==3){
            iconFlag = true;
        }
    }

    public void get3Headings(){

        ArrayList<String> HeadingsList = new ArrayList<>();

        String heading1 = driver.findElement(By.xpath("/html/body/div/main/table[1]/tbody/tr[1]/td/h4")).getText();
        if(heading1 != ""){
            HeadingsList.add(heading1);
        }

        String heading2 = driver.findElement(By.xpath("/html/body/div/main/table[2]/tbody/tr[1]/td/h4")).getText();
        if(heading2 != ""){
            HeadingsList.add(heading2);
        }

        String heading3 = driver.findElement(By.xpath("/html/body/div/main/table[3]/tbody/tr[1]/td/h4")).getText();
        if(heading3 != ""){
            HeadingsList.add(heading3);
        }

        //if there indeed are 3 icons
        if(HeadingsList.size()==3){
            headingFlag = true;
        }
    }

    public void getHeadings(){
        List<WebElement> HeadingsList = driver.findElements(By.tagName("h4"));


        //if there are 5 headings
        if(HeadingsList.size()==5){
            counter = 5;
        }
    }

    public void getIcons(){
        List<WebElement> IconList = driver.findElements(By.xpath("//h4/img"));

        //if there are 5 headings
        if(IconList.size()==1){
            counter = 1;
            temp  = IconList.get(0).getAttribute("src");
        }
    }

    public void getIconType(){
        temp = temp.replace("https://www.marketalertum.com/images/", "");
    }

    public void get3Descriptions(){

        ArrayList<WebElement> descriptionList = new ArrayList<>();

        WebElement description1 = driver.findElement(By.xpath("/html/body/div/main/table[1]/tbody/tr[3]/td"));
        descriptionList.add(description1);

        WebElement description2 = driver.findElement(By.xpath("/html/body/div/main/table[2]/tbody/tr[3]/td"));
        descriptionList.add(description2);

        WebElement description3 = driver.findElement(By.xpath("/html/body/div/main/table[3]/tbody/tr[3]/td"));
        descriptionList.add(description3);

        //if there indeed are 3 icons
        if(descriptionList.size()==3){
            descriptionFlag = true;
        }
    }

    public void get3Images(){

        ArrayList<WebElement> imageList = new ArrayList<>();

        WebElement image1 = driver.findElement(By.xpath("/html/body/div/main/table[1]/tbody/tr[2]/td/img"));
        imageList.add(image1);

        WebElement image2 = driver.findElement(By.xpath("/html/body/div/main/table[2]/tbody/tr[2]/td/img"));
        imageList.add(image2);

        WebElement image3 = driver.findElement(By.xpath("/html/body/div/main/table[3]/tbody/tr[2]/td/img"));
        imageList.add(image3);

        //if there indeed are 3 icons
        if(imageList.size()==3){
            imageFlag = true;
        }
    }

    public void get3Prices(){

        ArrayList<WebElement> priceList = new ArrayList<>();

        WebElement price1 = driver.findElement(By.xpath("/html/body/div/main/table[1]/tbody/tr[4]/td/b"));
        priceList.add(price1);

        WebElement price2 = driver.findElement(By.xpath("/html/body/div/main/table[2]/tbody/tr[4]/td/b"));
        priceList.add(price2);

        WebElement price3 = driver.findElement(By.xpath("/html/body/div/main/table[3]/tbody/tr[4]/td/b"));
        priceList.add(price3);

        //if there indeed are 3 icons
        if(priceList.size()==3){
            priceFlag = true;
        }
    }

    public void get3Links(){

        ArrayList<WebElement> linkList = new ArrayList<>();

        WebElement link1 = driver.findElement(By.xpath("/html/body/div/main/table[1]/tbody/tr[5]/td/a"));
        linkList.add(link1);

        WebElement link2 = driver.findElement(By.xpath("/html/body/div/main/table[2]/tbody/tr[5]/td/a"));
        linkList.add(link2);

        WebElement link3 = driver.findElement(By.xpath("/html/body/div/main/table[3]/tbody/tr[5]/td/a"));
        linkList.add(link3);

        //if there indeed are 3 icons
        if(linkList.size()==3){
            linkFlag = true;
        }
    }
}