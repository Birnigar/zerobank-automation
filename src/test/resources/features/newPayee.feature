@add_new_payee
Feature:Add	new	payee under pay bills

  Scenario:    Add	a new payee
    Given user is on the login page
    When user enter "username" and "password" and click the sign in button
    Then user navigates to "Pay Bills" page
    And user should navigate to "Add New Payee" sub-page
    And    creates	new	payee	using	following	information
    |Payee Name|The Law Offices of Hyde, Price & Scharks|
    |Payee Address|100 Same st, Anytown, USA, 10001     |
    |Account      |Checking                             |
    |Payee Details|XYZ account                          |

    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed