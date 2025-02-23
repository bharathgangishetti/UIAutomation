Feature: Login Functionality

  Scenario: User logs in successfully
    Given I launch the application
    When I enter valid username and password
    Then I should be logged in successfully
