package StepDefination;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;
import pages.LoginPage;
import utils.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class StepDefination {
    WebDriver driver;

    @Given("I launch the application")
    public void i_launch_the_application() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-features=NetworkService");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getConfigValue("BASE_URL"));
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        WebElement username = driver.findElement(LoginPage.username());
        WebElement password = driver.findElement(LoginPage.password());
        WebElement loginButton = driver.findElement(LoginPage.getLoginButton());

        username.sendKeys(JsonReader.getCredential("username"));
        password.sendKeys(JsonReader.getCredential("password"));
        loginButton.click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("Login successful.");
        driver.quit();
    }
}
