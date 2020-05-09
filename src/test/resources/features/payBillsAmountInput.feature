@pay_bills
Feature: Pay Bills
  As user, I should not able to enter alphabetic or special character to amount field.

  @pay_bill_amount_alphabetic_special
  Scenario Outline: Amount field should not accept alphabetical or special characters.
    Given user is on the login page
    When user enter "username" and "password" and click the sign in button
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Pay Saved Payee" sub-page
    Then user should choose a Payee "<Payee>"
    Then user should choose an Account type "<Account>"
    Then user should enter an Amount "<Amount>"
    Then user should enter a Date "<Date>"
    Then user should enter a Description "<Description>"
    And user should verify that amount field doesn't accept alphabetic or special character

    Examples:
      | Payee           | Account     | Amount      | Date       | Description  |
      | Sprint          | Savings     | test        | 2020-05-10 | Test payment |
      | Sprint          | Savings     | $$$$$$$$    | 2020-05-10 | Test payment |
      | Bank of America | Loan        | te100st     | 2020-05-10 | Test payment |
      | Apple           | Loan        | $$$100$$$$$ | 2020-05-10 | Test payment |
      | Wells Fargo     | Credit Card | $$aa100     | 2020-05-10 | Test payment |
