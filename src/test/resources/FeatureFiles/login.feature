Feature: Login Functionality

  # Scenario: Automate Walmart Job Application 
  #   When User launch "AMEX_URL" application
  #   And User Maximises the window
  #   When user holds for 5 seconds
  #   Then User closes the modal
  #   When User enter "AmexJobId"
  #   Then User click on "AmexGoButton"
  #   When user holds for 5 seconds
  #   Then User click on "AmexApplyJob"
  #   When user holds for 5 seconds
  #   Then User click on Iagreepage
  #   # Then User click on "AmexIAgree"
  #   # When the user scrolls to the element with id "exampleId"
  #   When user holds for 5 seconds
    
    

  # Scenario: User Sign Up successfully
  #   When User launch "BASE_URL" application
  #   And User Maximises the window
  #   Then User click on "Register"
  #   When User enter "SignUpDetails"
  #   Then User click on "confirmRegister"
  #   When user holds for 5 seconds
  #   Then User shoud verify "accountCreatedMsg" message is displyed
  #   Then User closes the browser

  # Scenario: User logs in successfully
  #   When User launch "BASE_URL" application
  #   And User Maximises the window
  #   When User enter "credentials"
  #   When user holds for 5 seconds
  #   Then User click on "LoginButton"
  #   Then User shoud verify "LoginSuccessMessage" message is displyed
  #   Then User closes the browser

  Scenario: Automate Walmart Job Application
    When User launch "WALMART_URL" application
    And User Maximises the window
    When user holds for 5 seconds
    Then User click on "walmartSignInLink"
    When user holds for 5 seconds
    When User enter "walmartSigninCreds"
    When user holds for 5 seconds
    Then User click on "walmartSignInButton"
    When user holds for 5 seconds
    When User enter "walmartJobId"
    Then User click on "walmartSearchJobId"
    When user holds for 5 seconds
    Then User click on "walmartClickOnJob"
    When user holds for 5 seconds
    Then User click on "walmartApplyButton"
    When user holds for 5 seconds
    Then User click on "walmartUseLastApplication"
    When user holds for 5 seconds
    Then User click on "walmartReferralPromptSearch"
    Then User click on "walmartReferral"
    Then User click on "walmartReferralLink"
    Then User click on "walmartSaveAndContinue"
    When user holds for 5 seconds
    Then User click on "walmartSaveAndContinue"
    When I select "No" from the "meet all minimum qualifications" dropdown
    # When I select "Opt-Out from receiving text messages from Walmart" from the "Message and data rates may apply" dropdown
    # When I select "No" from the "Are you legally able to work in the country" dropdown
    When I select "18 years of age and Over" from the "Please select your age category:" dropdown
    When I select "Have never been an employee of Walmart Inc or any of its subsidiaries" from the "Please select your Walmart Associate Status" dropdown
    When I select "Yes" from the "Are you able to provide work authorization" dropdown
    When I select "No" from the "The following questions are to assist Walmart" dropdown
    When I select "No" from the "Are you the Spouse/Partner of someone" dropdown
    When I select "No" from the "Do you have a direct family member who currently" dropdown
    When I select "No" from the "Will you now or in the future require "sponsorship" dropdown
    Then User click on "walmartSaveAndContinue"
    # Then User closes the browser
    

  
