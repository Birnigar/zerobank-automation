package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummary extends AbstractPageBase {
    @FindBy(xpath = "//div//h2")
    protected List<WebElement>  accountTypes;

    @FindBy(xpath = "//h2[text()=\"Credit Accounts\"]/following-sibling::div[1]//th")
    protected List<WebElement> creditAccountColumns;

    public List<String> getAccountTypes(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(accountTypes);
    }

    public List<String> getCreditAccountColumns(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(creditAccountColumns);
    }
}
