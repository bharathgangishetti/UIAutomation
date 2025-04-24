package StepDefination;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


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
                // button.click();
                Actions actions = new Actions(driver);
                actions.moveToElement(button).click().perform();
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

    @Then("User closes the modal")
    public void user_closes_the_modal() {

        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
            System.out.println("Modal is displayed!");

            // Click on "Skip" Button
            WebElement skipButton = driver.findElement(By.xpath("//button[text()='Skip']"));
            skipButton.click();
            System.out.println("Skipped modal successfully!");

        } catch (TimeoutException e) {
            System.out.println("Modal did not appear.");
        }
    
    }

    @When("the user scrolls to the element with id {string}")
    public void the_user_scrolls_to_the_element_with_id(String string) {

        By elementToBeScrolled = LoginPage.getLocator(string);
        System.out.println("Element to be scrolled: " + elementToBeScrolled);
        
        // Use JavaScriptExecutor to scroll to the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToBeScrolled);
        
    }

    @Then("User click on Iagreepage")
    public void user_click_on_iagreepage() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Print all input buttons
            List<WebElement> buttons = driver.findElements(By.tagName("input"));
            for (WebElement button : buttons) {
                System.out.println("Button Found: " + button.getAttribute("value") + " | ID: " + button.getAttribute("id"));
            }

    // Wait for "I Agree" button to appear
            WebElement agreeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value, 'I Agree')]")));

    // Print if button is found
            System.out.println("Is Displayed? " + agreeButton.isDisplayed());
            System.out.println("Is Enabled? " + agreeButton.isEnabled());

    // Scroll and Click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreeButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeButton);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @When("I select {string} from the {string} dropdown")
    public void i_select_value_from_dropdown(String optionToSelect, String dropdownLabel) {
    // WebDriver driver = DriverManager.getDriver();

    // Create dynamic XPath using the dropdown label
    String dropdownXPath = String.format(
        "//*[contains(text(), '" + dropdownLabel + "')]/ancestor::legend/following-sibling::div//button[contains(text(), 'Select One')]",
        dropdownLabel
    );

    // Click to open the dropdown
    WebElement dropdownButton = driver.findElement(By.xpath(dropdownXPath));
    dropdownButton.click();


    By optionLocator = By.xpath(
        "//div[@visibility='opened']//ul[@role='listbox']//div[normalize-space(text())='" + optionToSelect + "']"
    );
    WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
    wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


}

