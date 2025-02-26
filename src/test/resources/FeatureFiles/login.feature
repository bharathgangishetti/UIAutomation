Feature: Login Functionality

  Scenario: User logs in successfully
    Given I launch the application
    And User Maximises the window
    When I enter "credentials"
    Then I click on "LoginButton"
    When user holds for 10 seconds
    Then I should be logged in successfully
