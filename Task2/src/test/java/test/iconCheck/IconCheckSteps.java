package test.iconCheck;

import Alert.Alert;
import Login.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IconCheckSteps {
    Login login;
    Alert alert;

    WebDriver driver;

    @Given("I am an administrator of the website and I upload an alert of type {int}")
    public void iAmCreating1Alert(int Type) {
        System.setProperty("webdriver.chrome.driver","/Users/User/webtesting/chromedriver.exe");
        driver = new ChromeDriver();
        alert = new Alert(driver);
        try{
            alert.Create1Alert(Type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("I am a user of marketalertum {string}")
    public void iAmLoggingValid(String username) {
        login = new Login(driver);
        login.loginAction(username);
    }

    @When("I view a list of alerts")
    public void iViewTheListOfAlerts() {
        //already on the List page
    }

    @Then("I should see one alert")
    public void iShouldGet1Alert() {
        alert.getIcons();
        Assertions.assertEquals(alert.counter, 1);
    }

    @And("the icon displayed should be {string}")
    public void iShouldGetIconType(String iconType) {
        alert.getIconType();
        Assertions.assertEquals(alert.temp, iconType);
    }

}
