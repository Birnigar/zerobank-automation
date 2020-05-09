@online_statements
  Feature: Statements and Documents Details
    Background: open the page
      Given user is on the login page
      When user enter "username" and "password" and click the sign in button
      And user navigates to "Pay Bills" page
      And user should navigate to "Online Statements" sub-page

      Scenario Outline: Recent statements per year
        When user select the Recent Statements Year "<year>"
        Then "<year>" statements "<count>" should be displayed for that year

        Examples:
        |year|count|
        |2009|2    |
        |2010|2    |
        |2011|2    |
        |2012|1    |


        Scenario Outline: Download statements
          And user select the Recent Statements Year "<year>"
          When user clicks on statement "<statement>"
          Then downloaded file name should contain "<name>"
          And the file type should be pdf

          Examples:
          |year|statement|name|
          |2009|Statement 31/11/09(57K)|31-11-09|
          |2010|Statement 01/12/09(57K)|01-12-10|
          |2011|Statement 05/12/11(57K)|05-12-11|
          |2012|Statement 01/10/12(57K)|01-10-12|
