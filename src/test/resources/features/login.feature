@login
Feature: Login page

  Background: open login page
  @login_1
  Scenario: Authorized user only navigate to page
    Given user is on the login page
    When user enter "username" and "password" and click the sign in button
    Then verify Account summary page displayed

  @login_2
  Scenario: User with wrong username and wrong password should not be able to login
    Given user is on the login page
    When user enter wrong username and wrong password and click the sign in button
    Then verify warning message display