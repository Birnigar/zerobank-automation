package com.zerobank.stepdefinition;

import com.zerobank.pages.AccountActivity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinition {
    AccountActivity accountActivity=new AccountActivity();

    @Then("user should verify that default option is {string}")
    public void user_Should_Verify_That_Default_OptionIs(String accountType) {
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


    @When("user clicks on	{string} link on the Account Summary page")
    public void user_ClicksOn_LinkOn_TheAccount_SummaryPage(String accountName) {
        accountActivity.getAccountType(accountName);
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        accountActivity.enterDataTo(from,"fromDate");
        accountActivity.enterDataTo(to,"toDate");
    }


    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {
       Assert.assertTrue(accountActivity.isItInTheRange(from,to,new AccountActivity().getDataFromTable("Date")));
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
     Assert.assertTrue(accountActivity.isItSortedRecentToOld(new AccountActivity().getDataFromTable("Date")));
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        Assert.assertFalse(accountActivity.isDateListed(string,new AccountActivity().getDataFromTable("Date")));
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(accountActivity.isDataListed(string,new AccountActivity().getDataFromTable("Description")));
    }

    @Then("the results table should not show description containing {string}")
    public void the_results_table_should_not_show_description_containing(String string) {
        Assert.assertFalse(accountActivity.isDataListed(string,new AccountActivity().getDataFromTable("Description")));
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        Assert.assertTrue(accountActivity.isDataListed(new AccountActivity().getDataFromTable(string)));
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        accountActivity.selectFrom("type",string);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        Assert.assertFalse(accountActivity.isDataListed(new AccountActivity().getDataFromTable(string)));
    }

}