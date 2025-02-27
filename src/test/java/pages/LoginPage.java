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
        LOCATORS.put("LoginSuccessMessage", By.xpath("//*[contains(text(),'Account Services')]"));
        LOCATORS.put("Register", By.xpath("//a[contains(text(),'Register')]"));

        LOCATORS.put("firstName", By.xpath("//*[@id='customer.firstName']"));
        LOCATORS.put("lastName", By.xpath("//*[@id='customer.lastName']"));
        LOCATORS.put("address", By.xpath("//*[@id='customer.address.street']"));
        LOCATORS.put("city", By.xpath("//*[@id='customer.address.city']"));
        LOCATORS.put("state", By.xpath("//*[@id='customer.address.state']"));
        LOCATORS.put("zipCode", By.xpath("//*[@id='customer.address.zipCode']"));
        LOCATORS.put("phoneNumber", By.xpath("//*[@id='customer.phoneNumber']"));
        LOCATORS.put("ssn", By.xpath("//*[@id='customer.ssn']"));
        LOCATORS.put("selectUsername", By.xpath("//*[@id='customer.username']"));
        LOCATORS.put("selectPassword", By.xpath("//*[@id='customer.password']"));
        LOCATORS.put("confirmPassword", By.xpath("//*[@id='repeatedPassword']"));
        LOCATORS.put("confirmRegister", By.xpath("//*[@type='submit' and @value='Register']"));
        LOCATORS.put("accountCreatedMsg", By.xpath("//*[contains(text(),'Your account was created successfully. You are now logged in.')]"));
    }

    public static By getLocator(String key) {
        return LOCATORS.get(key);
    }
}