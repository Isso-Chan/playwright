Feature: Login-1

  @all
  Scenario Outline: Login to SwagLabs Application with Correct credentials-1
    Given User launched SwagLabs application
    Then "5" should be equal to "15"
    When User verify the Page title
    When User logged in the app using username "<UserName>" and password "<Password>"
    Then User verify the product name "<ProductName>"
    Then User logout from the application
    And all softAssertions are executed
    Examples:
      | UserName      | Password     | ProductName         |
      | standard_user | secret_sauce | Sauce Labs Backpack |