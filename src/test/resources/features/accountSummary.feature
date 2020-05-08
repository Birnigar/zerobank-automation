@account_summary
Feature: Account Summary

  Background: open login page
    Given user is on the login page
    And user enter "username" and "password" and click the sign in button
     When user navigates to "Account Summary" page

  Scenario: Account Summary page title should be Zero - Account Summary
       Then user should verify that title is "Zero - Account Summary"

  Scenario: Account Summary page account types
      Then Account Summary page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Account table columns
    Then Credit Accounts table should have the following columns
      | Account     |
      | Credit Card |
      | Balance     |
