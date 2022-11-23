Feature: Login-2

  @all @login2
  Scenario Outline: Login to SwagLabs Application with Correct credentials-2
    Given User launched SwagLabs application
    When User verify the Page title
    Then "Ali" should be equal to "Ali"
    When User logged in the app using username "<UserName>" and password "<Password>"
    Then User verify the product name "<ProductName>"
    Then User logout from the application
    And all softAssertions are executed
    Examples:
      | UserName      | Password     | ProductName   |
      | standard_user | secret_sauce | No code here! |