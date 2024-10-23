Feature: Test Feature

  @First
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

  @API
  Scenario: Verify Get booking
    Given I set the request payload to fetch bookings
    When I send request to fetch the booking details
    Then I validate the response

  @POST
  Scenario: Create a new booking
    Given I set the request payload to create bookings
    When I send request to create a new booking
    Then I validate the response