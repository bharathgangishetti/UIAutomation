package pages;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {

    private static final Map<String, By> LOCATORS = new HashMap<>();

    static {
        LOCATORS.put("username", By.xpath("//input[@name='username']"));
        LOCATORS.put("password", By.xpath("//input[@name='password']"));
        // Add more locators as needed
        // Example: LOCATORS.put("email", By.id("email"));
        // Example: LOCATORS.put("firstName", By.name("firstName"));
    }

    public static By getLocator(String key) {
        return LOCATORS.get(key);
    }

    public static By getLoginButton() {
        return By.xpath("//input[@value='Log In']");
    }
}