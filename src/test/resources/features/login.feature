@Wip
Feature: Login Functionality
  As : As a user I want to be able to login to the application

  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I enter "<userType>" username and password
    And I click on the login button
    Then I should be logged in


    Examples:
      | userType     |
      | Driver       |
      | SalesManager |
      | StoreManager |


     Scenario: Login with invalid credentials
       Given I am on the login page