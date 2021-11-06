@AllTesting @Register
Feature: Try to register

  @Register
  Scenario: User Register
    Given user navigates to "bukalapak web"
    When user click on register button
    And user register using wrong email "gajahbundar"
    Then user verify input wrong email
    And user register using valid email
    And user input wrong OTP "000000"
    Then user verify the wrong OTP