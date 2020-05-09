@account_activity_navigation
Feature: Navigating to specific accounts in Accounts Activity

  Background: Login with valid credentials
    Given user is on the login page
    When user enter "username" and "password" and click the sign in button

  Scenario:	Savings	account	redirect
    When user clicks on	"Savings" link on the Account Summary page
    Then user navigates to "Account Activity" page
    And user should verify that default option is "Savings"

  Scenario:	Brokerage	account	redirect
    When user clicks on	"Brokerage" link on the Account Summary page
    Then user navigates to "Account Activity" page
    And user should verify that default option is "Brokerage"

  Scenario:	Checking account	redirect
    When user clicks on	"Checking" link on the Account Summary page
    Then user navigates to "Account Activity" page
    And user should verify that default option is "Checking"

  Scenario:	CreditCard	account	redirect
    When user clicks on	"Credit Card" link on the Account Summary page
    Then user navigates to "Account Activity" page
    And user should verify that default option is "Credit Card"

  Scenario:	Loan account redirect
    When user clicks on	"Loan" link on the Account Summary page
    Then user navigates to "Account Activity" page
    And user should verify that default option is "Loan"