@demo-login

Feature: Demo Login

  Scenario: Login with valid credentials
    Given I open the demo page
    When I enter valid credentials
    Then The log in is successfully
