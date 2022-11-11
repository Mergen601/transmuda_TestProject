Feature: Verify "Rememeber me" checkbox functionality
         Us: As a user I should able to click on "Remember me" checkbox and
         it should remember my login credentials for next time.


  @RememberMe
  Scenario: Verify "Remember me" checkbox is clickable
    Given I am on the login page
    When I click on Remember me checkbox
    Then Remember me checkbox should be checked