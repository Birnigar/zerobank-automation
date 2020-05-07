package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle(){
        BrowserUtils.waitForPageToLoad(20);
        return driver.getTitle();
    }


    public void navigateTo(String tabName){
        String tabNameXpath = "//ul/li/a[text()='" + tabName + "']";
        WebElement tab = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
    }
}
