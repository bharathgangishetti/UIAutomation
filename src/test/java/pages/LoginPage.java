package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static By username() {
        return By.xpath("//input[@name='username']");
    }

    public static By password() {
        return By.xpath("//input[@name='password']");
    }

    public static By getLoginButton() {
        return By.xpath("//input[@value='Log In']");
    }
}
