package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public WebDriver driver;
    public String currentUrl;

    public Login(WebDriver Driver){
        this.driver = Driver;
    }

    public void loginAction(String username){


        //Go to marketalertum.com
        driver.get("https://www.marketalertum.com/");

        //go to login page
        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).click();

        //select searchbar
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"UserId\"]"));

        //type username in searchbar
        searchField.sendKeys(username);

        //press submit button
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/main/form/input[2]"));
        submitButton.submit();

        //get the current url
        currentUrl = driver.getCurrentUrl();
    }
}
