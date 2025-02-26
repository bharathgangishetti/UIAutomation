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
import java.util.Map; 
import java.util.HashMap; 
import java.util.Iterator; 
import java.util.Map.Entry; 
import org.openqa.selenium.By;


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

    // @When("I enter valid username and password")
    // public void i_enter_valid_username_and_password() {
    //     WebElement username = driver.findElement(LoginPage.username());
    //     WebElement password = driver.findElement(LoginPage.password());
    //     WebElement loginButton = driver.findElement(LoginPage.getLoginButton());

    //     username.sendKeys(JsonReader.getCredential("username"));
    //     password.sendKeys(JsonReader.getCredential("password"));
    //     loginButton.click();
    // }

    @When("I enter {string}")
    public void i_enter(String credentialsKey) {
        Map<String, String> credentialsMap = JsonReader.getCredentials(credentialsKey);
        System.out.println("Retrieved Credentials: " + credentialsMap);

        if (credentialsMap != null) {
        for (Entry<String, String> entry : credentialsMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            By locator = LoginPage.getLocator(key); // Get the locator dynamically

            if (locator != null) {
                try {
                    WebElement element = driver.findElement(locator);
                    element.sendKeys(value);
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.err.println("Element not found for key: " + key + ". Check your locator in LoginPage.");
                }
            } else {
                System.err.println("Locator not defined for key: " + key + ". Add it to LoginPage.");
            }
        }
        WebElement loginButton = driver.findElement(LoginPage.getLoginButton());
        loginButton.click(); 
        }
    }

    // @Then("I click on {string}")
    // public void i_click_on(String string) {
    //     By buttonLocator = LoginPage.getLocator(buttonName);

    //     if (buttonLocator != null) {
    //         try {
    //             WebElement button = driver.findElement(buttonLocator);
    //             button.click();
    //         } catch (org.openqa.selenium.NoSuchElementException e) {
    //             System.err.println("Button not found: " + buttonName + ". Check your locator in LoginPage.");
    //         }
    //     } else {
    //     System.err.println("Locator not defined for button: " + buttonName + ". Add it to LoginPage.");
    //     }
    // }
    


    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("Login successful.");
        driver.quit();
    }
}

