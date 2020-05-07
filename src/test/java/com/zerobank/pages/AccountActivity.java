package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends AbstractPageBase{


    @FindBy(id="aa_accountId")
    private WebElement accountSelectDropdown;

    @FindBy(xpath = "//tr//th")
    private List<WebElement> transactionColumnNames;



    Select select=new Select(accountSelectDropdown);


    public String getDefaultOption(){
        BrowserUtils.waitForPageToLoad(20);
       return  select.getFirstSelectedOption().getText();
    }
    public void clickAccountDropDown(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(accountSelectDropdown)).click();
    }

    public List<String> getAllOption(){
       BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public List<String> getTransactionColumnNames(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(transactionColumnNames);
    }

}
