@demo-login

Feature: Demo Login

  Scenario: Login with valid credentials
    Given I open the demo page
    When I enter valid credentials
    Then I log in successfully
