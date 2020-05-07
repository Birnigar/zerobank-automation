package com.zerobank.stepdefinition;

import com.zerobank.pages.AccountSummary;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinition {
    AccountSummary accountSummary=new AccountSummary();

    @When("user navigates to {string} page")
    public void user_Navigates_To_Page(String tabName) {
        System.out.println("user navigate to :"+tabName);
        accountSummary.navigateTo(tabName);
    }

    @Then("user should verify that title is {string}")
    public void user_Should_Verify_That_TitleIs(String pageTitle) {
        accountSummary.getPageTitle();
        Assert.assertEquals(accountSummary.getPageTitle(),pageTitle);
    }

    @Then("Account Summary page should have the following account types")
    public void account_Summary_page_should_have_the_following_account_types(List<String> dataTable) {
        System.out.println("Expected values :: " + dataTable);
        Assert.assertEquals(accountSummary.getAccountTypes(), dataTable);
    }

    @Then("Credit Accounts table should have the following columns")
    public void credit_Accounts_table_should_have_the_following_columns(List<String> dataTable) {
        System.out.println("Expected values :: " + dataTable);
        Assert.assertEquals(accountSummary.getCreditAccountColumns(), dataTable);
    }
}
