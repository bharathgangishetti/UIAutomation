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
    # Then User closes the browser
    

  
