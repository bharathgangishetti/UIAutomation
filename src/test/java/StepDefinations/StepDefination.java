package StepDefination;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



import java.time.Duration;

public class StepDefination {
    WebDriver driver;
    WebDriverWait wait;

    @When("User launch {string} application")
    public void user_launch_application(String string) {
        String url = string;
        String chromeDriverPath = ConfigReader.getConfigValue("CHROME_DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-features=NetworkService");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getConfigValue(url));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // @Given("User launch the application")
    // public void i_launch_the_application() {
    //     System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

    //     ChromeOptions options = new ChromeOptions();
    //     options.addArguments("--remote-allow-origins=*");
    //     options.addArguments("--disable-dev-shm-usage");
    //     options.addArguments("--disable-gpu");
    //     options.addArguments("--disable-popup-blocking");
    //     options.addArguments("--disable-features=NetworkService");
    //     options.addArguments("--no-sandbox");

    //     driver = new ChromeDriver();
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //     driver.get(ConfigReader.getConfigValue("BASE_URL"));
    // }

    @Given("User Maximises the window")
    public void user_maximises_the_window() {
        driver.manage().window().maximize();
    }

    @When("user holds for {int} seconds")
    public void user_hols_for_seconds(Integer int1) throws InterruptedException {
       Thread.sleep(int1 * 1000);
    }


    @When("User enter {string}")
    public void i_enter(String credentialsKey) {
        Map<String, String> credentialsMap = JsonReader.getCredentials(credentialsKey);
        System.out.println("Retrieved Credentials: " + credentialsMap);

        if (credentialsMap != null) {
            for (Entry<String, String> entry : credentialsMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                By locator = LoginPage.getLocator(key);

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
        }
    }

    @When("User click on {string}") 
    public void i_click_on(String buttonName) { 
        By buttonLocator = LoginPage.getLocator(buttonName);

        if (buttonLocator != null) {
            try {
                WebElement button = driver.findElement(buttonLocator);
                button.click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.err.println("Button not found: " + buttonName + ". Check your locator in LoginPage.");
            }
        } else {
            System.err.println("Locator not defined for button: " + buttonName + ". Add it to LoginPage.");
        }
    }


    @Then("User closes the browser")
    public void i_closes_the_browser() {
        driver.quit();
    }


    // unimplementedmethod 
    @Then("iShouldSeeTheSignInModalPopup")
    public void i_should_see_the_sign_in_modal_popup() {
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='dialog' and @data-automation-id='popUpDialog']")
        ));
        assert modal.isDisplayed();

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-automation-id='email']")));
        emailField.sendKeys("test@example.com");

        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-automation-id='password']")));
        passwordField.sendKeys("yourpassword");

        WebElement button = driver.findElement(By.cssSelector("[data-automation-id='signInSubmitButton']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();

        // WebElement button = modal.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        // button.click();

        // Click on the "Sign In" button
        // WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sign In']")));
        // submitButton.sendKeys(Keys.ENTER);
        
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();", submitButton);

    
    }

    @Then("User shoud verify {string} message is displyed")
    public void i_shoud_verify_message_is_displyed(String string) {
        By expectedTextLocator = LoginPage.getLocator(string);
        String expectedText = driver.findElement(expectedTextLocator).getText();
        String actualText = JsonReader.getValueByKey(string);
        System.out.println("Expected Text: " + expectedText);
        System.out.println("Actual Text: " + actualText);
        System.out.println("expectedTextLocator: " + expectedTextLocator);
        assert expectedText.equals(actualText);
    }
}

