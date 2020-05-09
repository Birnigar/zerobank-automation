@pay_bills
Feature: Pay Bills
  As user, I want to be able to see successful Pay operation message.

  @pay_bill_success_message
  Scenario Outline: Successful Pay operation should give "The payment was successfully submitted." message.
    Given user is on the login page
    When user enter "username" and "password" and click the sign in button
    Then user should navigate to "Pay Bills" page
    And user should navigate to "Pay Saved Payee" sub-page
    Then user should choose a Payee "<Payee>"
    Then user should choose an Account type "<Account>"
    Then user should enter an Amount "<Amount>"
    Then user should enter a Date "<Date>"
    Then user should enter a Description "<Description>"
    Then user should complete process with "Pay" button
    And user should verify that success message "The payment was successfully submitted."

    Examples:
      | Payee             | Account     | Amount  | Date      | Description  |
      | Sprint            | Savings     | 1000    | 2020-05-10| Test payment |
      | Bank of America   | Checking    | 1000    | 2020-05-10| Test payment |
      | Bank of America   | Loan        | 1000    | 2020-05-10| Test payment |
      | Apple             | Credit Card | 1000    | 2020-05-10| Test payment |
      | Apple             | Brokerage   | 1000    | 2020-05-10| Test payment |
      | Wells Fargo       | Savings     | 1000    | 2020-05-10| Test payment |
      | Wells Fargo       | Credit Card | 1000    | 2020-05-10| Test payment |
      | Wells Fargo       | Brokerage   | 1000    | 2020-05-10| Test payment |