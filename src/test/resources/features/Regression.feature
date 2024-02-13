Feature: Test Feature
  Scenario: Login Test Scenario
    Given User is ready with test data
    When User launch the browser
    Then Chrome browser opened

    @Login
  Scenario: Web Login Test Scenario
    Given I create a webdriver instance
    And I navigate to login page
    When I complete the login process
    Then I should navigate to home page
    And I quit webdriver instance