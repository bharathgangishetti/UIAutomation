Feature: Login Functionality

  Scenario: User Sign Up successfully
    When User launch "BASE_URL" application
    And User Maximises the window
    Then User click on "Register"
    When User enter "SignUpDetails"
    Then User click on "confirmRegister"
    When user holds for 10 seconds
    Then User shoud verify "accountCreatedMsg" message is displyed
    Then User closes the browser

  Scenario: User logs in successfully
    When User launch "BASE_URL" application
    And User Maximises the window
    When User enter "credentials"
    When user holds for 5 seconds
    Then User click on "LoginButton"
    Then User shoud verify "LoginSuccessMessage" message is displyed
    Then User closes the browser

  Scenario: Automate Walmart Job Application
    When User launch "WALMART_URL" application
    And User Maximises the window
    When user holds for 5 seconds
    Then User click on "walmartSignInLink"
    When user holds for 15 seconds
    Then iShouldSeeTheSignInModalPopup
    Then User shoud verify "walmartPopUpDisplyed" message is displyed
    When User enter "walmartCredentials"
    When user holds for 5 seconds
    Then User click on "walmartSignInButton"
    When user holds for 5 seconds
    Then User closes the browser
    

  
