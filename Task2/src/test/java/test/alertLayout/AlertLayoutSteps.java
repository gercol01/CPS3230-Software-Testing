package test.alertLayout;

import Login.Login;
import Alert.Alert;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertLayoutSteps {
    Login login;
    Alert alert;

    WebDriver driver;

    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @Given("I am an administrator of the website and I upload 3 alerts")
    public void iAmCreatingAlerts() {
        System.setProperty("webdriver.chrome.driver","/Users/User/webtesting/chromedriver.exe");
        driver = new ChromeDriver();
        alert = new Alert(driver);
        try{
            alert.Create3Alerts();
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

    @Then("each alert should contain an icon {booleanValue}")
    public void iShouldGet3Icons(Boolean flag) {
        alert.get3Icons();
        Assertions.assertEquals(alert.iconFlag, flag);
    }

    @And("each alert should contain a heading {booleanValue}")
    public void iShouldGet3Headings(Boolean flag) {
        alert.get3Headings();
        Assertions.assertEquals(alert.headingFlag, flag);
    }

    @And("each alert should contain a description {booleanValue}")
    public void iShouldGet3Descriptions(Boolean flag) {
        alert.get3Descriptions();
        Assertions.assertEquals(alert.descriptionFlag, flag);
    }

    @And("each alert should contain an image {booleanValue}")
    public void iShouldGet3Images(Boolean flag) {
        alert.get3Images();
        Assertions.assertEquals(alert.imageFlag, flag);
    }

    @And("each alert should contain a price {booleanValue}")
    public void iShouldGet3Prices(Boolean flag) {
        alert.get3Prices();
        Assertions.assertEquals(alert.priceFlag, flag);
    }

    @And("each alert should contain a link to the original product website {booleanValue}")
    public void iShouldGetThe3Links(Boolean flag) {
        alert.get3Links();
        Assertions.assertEquals(alert.linkFlag, flag);
    }

}
