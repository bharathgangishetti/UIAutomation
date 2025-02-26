Feature: Login Functionality

  Scenario: User logs in successfully
    Given I launch the application
    When I enter "credentials"
    # Then I click on "LoginButton"
    Then I should be logged in successfully
