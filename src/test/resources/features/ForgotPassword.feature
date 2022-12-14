Feature: ForgotPassword menu functionality
  User Story: As a user, I want to be
  able to reset my password if I forget it.


  Scenario: User clicks on Forgot Password link
    Given I am on the login page
    When I click on the Forgot Password link
    Then I should be on the Forgot Password page

  @ForgotPassword
  Scenario Outline: User should able to change password with username after clicking on Request button
    Given I am on the Forgot Password page
    When I enter username "<username>" and click on Request button
    Then I should see the error message "<errorMesssage>"

    Examples:
      | username        | errorMesssage             |
      | user1           | Unable to send the email. |
      | salesmanager101 | Unable to send the email. |
      | storemanager51  | Unable to send the email. |