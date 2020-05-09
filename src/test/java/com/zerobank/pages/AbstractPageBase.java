package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageBase {
    protected String emptyField;

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle(){
        BrowserUtils.waitForPageToLoad(20);
        return driver.getTitle();
    }
    /**
     * Method for module navigation. Provide tab module to navigate
     * @param  tabName like:
     *               Account Summary
     *               Account Activity
     *               Transfer Funds
     *               Pay Bills
     *               My Money Map
     *               Online Statements
     */

    public void navigateTo(String tabName){
        String tabNameXpath = "//ul/li/a[text()='" + tabName + "']";
        WebElement tab = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
    }

    /**
     * This method helps you to click process for sub-module's complete button
     * @param processName should get:
     *                    Pay for Pay Saved Payee module
     *                    Add for Add New Payee module
     *                    Purchase for Purchase Foreign Currency module
     */
    public void completeProcess(String processName) {
        By element;
        if (processName.equalsIgnoreCase("Find")) {
            element = By.xpath("//button[text()='" + processName + "']");
        }else{
            element = By.cssSelector("input[value='" + processName + "']");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).click();
        BrowserUtils.wait(3);
    }

    /**
     * This method navigates between sub modules
     * @param module should get sub-module name:
     *              "Show Transactions"
     *              "Find Transactions"
     */
    public void navigateToSubPage(String module){
        driver.findElement(By.linkText(module)).click();
        BrowserUtils.waitForPageToLoad(10);
    }
    /**
     * Helps you to select from designated drop down
     * @param selectElementName accepts Element ID
     */
    public void selectFrom(String selectElementName, String optionText){
        new Select(driver.findElement(By.name(selectElementName))).selectByVisibleText(optionText);
    }


    /**
     * This method for data entry
     * @param data input data
     * @param element web element name
     */
    public void enterDataTo(String data, String element){
        emptyField=element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(element)));
        if(element.equals("account")){
            driver.findElement(By.xpath("//input[@name='account']")).sendKeys(data);
        }else{
            driver.findElement(By.name(element)).clear();
            driver.findElement(By.name(element)).sendKeys(data);
        }

    }
    /**
     * This method checks that input has alphabetic characters or not
     * @param element input WebElement
     * @return true if any alphabetic character entered
     *         false if only alphabetic character not entered
     *
     */
    public boolean isInputFieldContainsAlphabeticChar(WebElement element){
        String data=element.getAttribute("value");
        return !data.equals("")&& data!=null && data.matches(".*[a-zA-Z].*");
    }

    /**
     * This method checks that input has special character or not
     * @param element input WebElement
     * @return  true if any special character entered
     *          false if any special character not entered
     *
     */
    public  boolean isInputFieldContainsSpecialChar(WebElement element){
        String data=element.getAttribute("value");
        return !data.equals("")&& data!=null && data.matches(".*[^a-zA-Z0-9 ].*");
    }

}
