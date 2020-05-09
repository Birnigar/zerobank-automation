package com.zerobank.stepdefinition;

import com.zerobank.pages.OnlineStatementPage;
import com.zerobank.utulities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OnlineStatementStepDefinition {
    OnlineStatementPage onlineStatementPage=new OnlineStatementPage();

    @When("user select the Recent Statements Year {string}")
    public void user_select_the_Recent_Statements_Year(String string) {
        onlineStatementPage.navigateToStatement(string);
    }

    @Then("{string} statements {string} should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(String string, String string2) {
        Assert.assertTrue(onlineStatementPage.isDisplayed(string,string2));
    }

    @When("user clicks on statement {string}")
    public void user_clicks_on_statement(String string) {
        onlineStatementPage.navigateToStatement(string);
        BrowserUtils.wait(10);

    }
    @Then("downloaded file name should contain {string}")
    public void downloaded_file_name_should_contain(String string) {
        Assert.assertTrue(onlineStatementPage.isDownloaded(string));

    }
    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertTrue(onlineStatementPage.isDownloadedType("pdf"));

    }
}
