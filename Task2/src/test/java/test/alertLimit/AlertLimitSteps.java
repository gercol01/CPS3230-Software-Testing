package test.alertLimit;

import Alert.Alert;
import Login.Login;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertLimitSteps {
    Login login;
    Alert alert;

    WebDriver driver;

    @Given("I am an administrator of the website and I upload more than 5 alerts")
    public void iAmCreating5Alerts() {
        System.setProperty("webdriver.chrome.driver","/Users/User/webtesting/chromedriver.exe");
        driver = new ChromeDriver();
        alert = new Alert(driver);
        try{
            alert.Create6Alerts();
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

    @Then("I should see five alerts {int}")
    public void iShouldGet5Alerts(int counter) {
        alert.getHeadings();
        Assertions.assertEquals(alert.counter, counter);
    }

}
