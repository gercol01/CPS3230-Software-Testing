package test.validLogin;

import Login.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidLoginSteps {
    Login login;
    WebDriver driver;

    @Given("I am a user of marketalertum")
    public void iAmLoggingValid() {
        System.setProperty("webdriver.chrome.driver","/Users/User/webtesting/chromedriver.exe");
        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @When("I login using valid credentials {string}")
    public void iEnterUsernameInvalidAnd(String username) {
        login.loginAction(username);
    }

    @Then("I should see my alerts {string}")
    public void iShouldGetTheURLAlert(String currentUrl) {
        Assertions.assertEquals(currentUrl, login.currentUrl);
    }
}
