@purchase_foreign
  Feature: Purchase Foreign Currency

    Background:open the page
      Given user is on the login page
      And user enter "username" and "password" and click the sign in button
      And user navigates to "Pay Bills" page
      And user should navigate to "Purchase Foreign Currency" sub-page

    Scenario: Available	currencies
      Then following currencies should be available
        | Australia (dollar)    |
        | Canada (dollar)       |
        | Switzerland (franc)   |
        | China yuan)           |
        | Denmark (krone)       |
        | Eurozone (euro)       |
        | Great Britain (pound) |
        | Japan (yen)           |
        | Mexico (peso)         |
        | Norway (krone)        |
        | New	Zealand (dollar)  |
        | Singapore (dollar)    |


    Scenario:	Error	message for	not	selecting	currency
      When user tries to calculate cost without selecting a currency
      Then error message should be displayed


    Scenario:	Error message for not entering value
      When user tries to calculate cost without entering a value