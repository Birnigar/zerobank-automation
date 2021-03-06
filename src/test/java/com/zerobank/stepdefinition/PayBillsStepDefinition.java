package com.zerobank.stepdefinition;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinition {
    PayBillsPage payBillsPage=new PayBillsPage();

    @Then("user should navigate to {string} page")
    public void user_should_navigate_to_page(String tabName) {
        payBillsPage.navigateTo(tabName);

    }

    @Then("user should verify Pay Bills title is {string}")
    public void user_should_verify_Pay_Bills_title_is(String pageTitle) {
        Assert.assertEquals(payBillsPage.getPageTitle(),pageTitle);
    }

    @Then("user should navigate to {string} sub-page")
    public void user_should_navigate_to_sub_page(String subPage) {
       payBillsPage.navigateToSubPage(subPage);
    }




    @Then("user should choose a Payee {string}")
    public void user_should_choose_a_Payee(String string) {
        payBillsPage.selectFrom("payee",string);
    }

    @Then("user should choose an Account type {string}")
    public void user_should_choose_an_Account_type(String string) {
        payBillsPage.selectFrom("account",string);
    }
    @Then("user should enter an Amount {string}")
    public void user_should_enter_an_Amount(String string) {
        payBillsPage.enterDataTo(string,"amount");
    }
    @Then("user should enter a Date {string}")
    public void user_should_enter_a_Date(String string) {
        payBillsPage.enterDataTo(string,"date");
    }
    @Then("user should enter a Description {string}")
    public void user_should_enter_a_Description(String string) {
       payBillsPage.enterDataTo(string,"description");
    }
    @Then("user should complete process with {string} button")
    public void user_should_complete_process_with_button(String string) {
        payBillsPage.completeProcess(string);
    }

    @Then("user should verify that success message {string}")
    public void user_should_verify_that_success_message(String string) {
        Assert.assertEquals(string,payBillsPage.getAlert());
    }

    @Then("user should verify that required field message {string}")
    public void user_should_verify_that_required_field_message(String string) {
        Assert.assertEquals(string,payBillsPage.getRequiredFieldAlert());
    }

    @And("user should verify that amount field doesn't accept alphabetic or special character")
    public void userShould_VerifyThatAmountField_DoesnTAcceptAlphabetic_OrSpecialCharacter() {
        Assert.assertTrue(payBillsPage.isEntryCorrect("amount"));
    }

    @And("user should verify that date field doesn't accept alphabetic character")
    public void userShould_VerifyThatDateField_DoesnTAccept_AlphabeticCharacter() {
        Assert.assertTrue(payBillsPage.isEntryCorrect("date"));
    }

    @Then("creates	new	payee	using	following	information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        payBillsPage.enterDataTo(dataTable.get("Payee Name"),"name");
        payBillsPage.enterDataTo(dataTable.get("Payee Address"),"address");
        payBillsPage.enterDataTo(dataTable.get("Account"),"account");
        payBillsPage.enterDataTo(dataTable.get("Payee Details"),"details");
        payBillsPage.completeProcess("Add");
    }


    @Then("message {string} should be displayed")
    public void message_Should_Be_Displayed(String msg) {
        Assert.assertEquals(msg,payBillsPage.getAlert());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
      payBillsPage.isContainsOptions(dataTable,"pc_currency");
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.enterAmount("1000");
        payBillsPage.completeProcess("Calculate Costs");
    }
    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.completeProcess("Calculate Costs");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(payBillsPage.isWarningMessageDisplayed());
    }


}
