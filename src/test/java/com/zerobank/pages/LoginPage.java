package com.zerobank.pages;

import com.zerobank.utulities.ConfigurationReader;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "user_login")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(name = "submit")
    private WebElement login;

    @FindBy(xpath = "//a[text()='Account Summary']")
    private WebElement accountSummary;

    @FindBy(xpath = "//div[contains(text(),'Login and/or password are wrong.')]")
    private WebElement warningMessage;




    public void login(String userValue, String passwordValue) {
        userName.sendKeys(userValue);
        password.sendKeys(passwordValue);
        login.click();
    }

    public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();


    }
    public String getAccountSummaryText(){

        return accountSummary.getText();
    }

    public String getWarningMessage(){

        return warningMessage.getText();
    }
}
