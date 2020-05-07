package com.zerobank.stepdefinition;

import com.zerobank.pages.LoginPage;
import com.zerobank.utulities.ConfigurationReader;
import com.zerobank.utulities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {
    LoginPage loginPage=new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }
    @When("user enter {string} and {string} and click the sign in button")
    public void user_Enter_AndClick_TheSignInButton(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("verify Account summary page displayed")
    public void verify_Account_summary_page_displayed() {
      loginPage.getAccountSummaryText();
    }

    @When("user enter wrong username and wrong password and click the sign in button")
    public void userEnterWrongUsernameAndWrongPasswordAndClickTheSignInButton() {
        loginPage.login("wrong","wrong");
    }
    @Then("verify warning message display")
    public void verify_warning_message_display() {
       String expected="Login and/or password are wrong.";
        System.out.println(loginPage.getWarningMessage());
        Assert.assertEquals(loginPage.getWarningMessage(),expected);
    }


}
