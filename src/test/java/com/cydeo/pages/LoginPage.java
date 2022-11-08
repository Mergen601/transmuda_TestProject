package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

         public LoginPage(){
             PageFactory.initElements(Driver.getDriver(),this);
         }




    @FindBy(xpath = " //input[@name='_username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(xpath ="//div[.='Invalid user name or password.']")
    public WebElement errorMessageInvalidUserNameOrPassword;

    //In this method we are logging in with userType
    //#VaraiableName#  userType
    public void loginWithUserType(String userType){
        usernameBox.sendKeys(ConfigurationReader.getProperties(userType));
        passwordBox.sendKeys(ConfigurationReader.getProperties("Password"));
        loginButton.click();

    }

    public void loginWithUsernameAndPassword(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }







}
