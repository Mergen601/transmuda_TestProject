package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a")
    public WebElement forgotYourPasswordLink;
 
    




    //In this method we are logging in with userType
    //#VaraiableName#  userType
    public void loginWithUserType(String userType) {

        usernameInput.sendKeys(ConfigurationReader.getProperties(userType));
        passwordInput.sendKeys(ConfigurationReader.getProperties("Password"));


    }

    //In this method we are logging in with username and password
    //PARAMETER userName , password
    public void loginWithUsernameAndPassword(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

    }


}
