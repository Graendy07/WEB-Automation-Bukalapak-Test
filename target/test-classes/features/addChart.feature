@AllTesting @Login
Feature: Add chart any product

  @Login
  Scenario: User login and add product to chart
    Given user navigates to "bukalapak web"
    When user click on login button
    And user login and enter as tenant via email as "user testing"
    And user verify success login & toast message appear
    And user input & search product with value "monitor"
    And user choose 1st product on the list "OBRAL MURAH LCD MONITOR 19 INC WIDE SCREEN MULUS BERGARANSI"
    And user add product to chart
    Then verify product "19 INC WIDE SCREEN MULUS" added on chart
    And user delete product from chart
    Then validate the product is removed
    And user log out from web

