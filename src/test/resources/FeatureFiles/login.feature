Feature: Login Functionality

  # Scenario: User Sign Up successfully
  #   Given User launch the application
  #   And User Maximises the window
  #   Then User click on "Register"
  #   When User enter "SignUpDetails"
  #   Then User click on "confirmRegister"
  #   When user holds for 10 seconds
  #   Then User shoud verify "accountCreatedMsg" message is displyed
  #   Then User closes the browser

  Scenario: User logs in successfully
    Given User launch the application
    And User Maximises the window
    When User enter "credentials"
    When user holds for 5 seconds
    Then User click on "LoginButton"
    Then User shoud verify "LoginSuccessMessage" message is displyed
    Then User closes the browser

  
