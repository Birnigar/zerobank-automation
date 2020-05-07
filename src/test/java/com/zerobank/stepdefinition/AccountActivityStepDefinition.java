package com.zerobank.stepdefinition;

import com.zerobank.pages.AccountActivity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinition {
    AccountActivity accountActivity=new AccountActivity();

    @Then("user should verify that default option is {string} in the Account drop down")
    public void user_should_verify_that_default_option_is_in_the_Account_drop_down(String accountType) {
        System.out.println("Default account is : "+accountType);
        Assert.assertEquals(accountType,accountActivity.getDefaultOption());
    }


    @And("user clicks on Account drop down")
    public void userClicksOnAccountDropDown() {
        accountActivity.clickAccountDropDown();
    }

    @Then("Account drop down should have the following options")
    public void accountDropDownShouldHaveTheFollowingOptions(List<String> accountType) {
        accountActivity.getAllOption();

    }

    @Then("Transactions table should have the following column names")
    public void transactionsTableShouldHaveTheFollowingColumnNames(List<String> columNames) {
        accountActivity.getTransactionColumnNames();
    }
}