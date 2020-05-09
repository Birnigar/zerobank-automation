package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PayBillsPage  extends AbstractPageBase{


    @FindBy(xpath = "//input[@id='pc_amount']")
    private WebElement amountPlace;

    @FindBy(id ="alert_content" )
    private WebElement message;



    /**
     * Enter amount for foreign currency purchase
     * @param amount
     */
    public void enterAmount(String amount){
        BrowserUtils.wait(5);
        amountPlace.click();
        amountPlace.sendKeys(amount);
    }
    /**
     * This method verifies is alert displayed or not
     * @return true if alert displayed
     */
    public boolean isWarningMessageDisplayed(){
        return Driver.getDriver().switchTo().alert().getText().equals("Please, ensure that you have filled all the required fields with valid values.");
    }
    /**
     * This method returns required field message if required field leaved empty
     * @return message as String
     */
    public String getRequiredFieldAlert(){
        return (String)((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].validationMessage;", driver.findElement(By.name(emptyField)));
    }

    /**
     * This method returns process result message
     * @return message as String
     */
    public String getAlert(){
        return message.getText();
    }

    /**
     * This method returns empty field name
     * @return
     */
    public String getEmptyField() {
        return emptyField;
    }
    /**
     * This method checks entry type and returns if it is
     * @param elementName input field name
     * @return true if entry type correct
     *         false if entry type wrong
     *
     */
    public boolean isEntryCorrect(String elementName){
        WebElement inputElement=driver.findElement(By.name(elementName.toLowerCase()));
        if(elementName.equalsIgnoreCase("amount")){
            return !(isInputFieldContainsAlphabeticChar(inputElement) || isInputFieldContainsSpecialChar(inputElement));
        }
        else if (elementName.equalsIgnoreCase("date")){
            return !(isInputFieldContainsAlphabeticChar(inputElement));
        }
        return false;
    }
}
