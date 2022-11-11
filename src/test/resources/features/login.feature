Feature: Login Functionality
  As : As a user I want to be able to login to the application


  Scenario Outline: : Login with valid credentials
    Given I am on the login page
    When I enter vald "<userType>" credentials
    And I should click on login button
    Then I should be logged in

    Examples:
      | userType     |
      | Driver       |
      | SalesManager |
      | StoreManager |




  Scenario Outline: : Login with invalid credentials
    Given I am on the login page
    When I enter Invalid "<userName>" and "<password>" credentials
    And I should click on login button
    Then I should see "<expectedErrorMessage>"

    Examples:
      | userName        | password    | expectedErrorMessage           |
      | invalidUserName | invalidPass | Invalid user name or password. |
      | user1           | USERUSER123 | Invalid user name or password. |
      | Storemanager51  | UserUser123 | Invalid user name or password. |



  Scenario Outline:  Login with empty credentials
    Given I am on the login page
    When I enter empty "<userName>" and "<password>" credentials
    And I should click on login button
    Then I should see "<validationErrorMessage>" message

    Examples:
      | userName | password | validationErrorMessage    |
      |          |          | Lütfen bu alanı doldurun. |
      |          | asdsadsa | Lütfen bu alanı doldurun. |
      | asdsadsa |          | Lütfen bu alanı doldurun. |


  @login
  Scenario: User should see their password in bullet signs
    Given I am on the login page
    When I enter valid credentials
    Then I should see password in bullet signs



