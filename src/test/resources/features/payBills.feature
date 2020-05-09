@pay_bills
Feature: Pay Bills
  As user, I want to be able to see Pay Bills page title.

  @pay_bills_page_title
  Scenario: Pay Bills page should have the title Zero - Pay Bills
    Given user is on the login page
    When user enter "username" and "password" and click the sign in button
    Then user should navigate to "Pay Bills" page
    And user should verify Pay Bills title is "Zero - Pay Bills"