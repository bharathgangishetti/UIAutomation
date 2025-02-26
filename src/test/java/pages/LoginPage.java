package pages;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {

    private static final Map<String, By> LOCATORS = new HashMap<>();

    static {
        LOCATORS.put("username", By.xpath("//input[@name='username']"));
        LOCATORS.put("password", By.xpath("//input[@name='password']"));
        LOCATORS.put("LoginButton", By.xpath("//input[@value='Log In']"));
    }

    public static By getLocator(String key) {
        return LOCATORS.get(key);
    }
}