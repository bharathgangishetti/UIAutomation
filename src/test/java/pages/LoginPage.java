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


        LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        LOCATORS.put("walmartLoginEmail", By.xpath("//input[@autocomplete='email']"));
        LOCATORS.put("walmartLoginPassword", By.xpath("//input[@data-automation-id='password']"));
        LOCATORS.put("walmartSignInButton", By.xpath("//button[contains(text(),'Sign In')]"));
        LOCATORS.put("walmartPopUpDisplyed", By.xpath("//div[@data-automation-id='popUpDialog']"));
        LOCATORS.put("walmartJobId", By.xpath("//*[@data-automation-id='keywordSearchInput']"));
        LOCATORS.put("walmartSearchJobId", By.xpath("//button[@data-automation-id='keywordSearchButton']"));
        LOCATORS.put("walmartClickOnJob", By.xpath("//a[@data-automation-id='jobTitle']"));
        LOCATORS.put("walmartApplyButton", By.xpath("//a[@data-automation-id='adventureButton']"));
        LOCATORS.put("walmartUseLastApplication", By.xpath("//a[@data-automation-id='useMyLastApplication']"));
        LOCATORS.put("walmartReferralPromptSearch", By.xpath("(//*[@data-uxi-widget-type='selectinput'])[1]"));
        LOCATORS.put("walmartReferral", By.xpath("//div[@data-automation-id='promptOption' and @data-automation-label='Walmart Career Site']"));
        LOCATORS.put("walmartReferralLink", By.xpath("//*[@data-automation-label='Walmart Career Site']"));
        LOCATORS.put("walmartSaveAndContinue", By.xpath("//button[contains(text(),'Save and Continue')]"));
        LOCATORS.put("walmartTandC", By.xpath("//input[@id='termsAndConditions--acceptTermsAndAgreements']"));
        LOCATORS.put("walmartSubmitApplication", By.xpath("//button[@data-automation-id='pageFooterNextButton']"));
        

        LOCATORS.put("AmexFindJobs", By.xpath("//*[@title='Find Open Jobs']"));
        LOCATORS.put("AmexJobId", By.xpath("//*[@id='main-search-box']"));
        LOCATORS.put("AmexGoButton", By.xpath("//button[@class='go-button']"));
        LOCATORS.put("AmexApplyJob", By.xpath("//button[@data-test-id='apply-button']"));
        LOCATORS.put("AmexIAgree", By.xpath("//input[contains(@value, 'I Agree')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
        // LOCATORS.put("walmartSignInLink", By.xpath("//span[contains(text(),'Sign In')]"));
    }

    public static By getLocator(String key) {
        return LOCATORS.get(key);
    }
}