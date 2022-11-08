package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
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

    @FindBy(id = "_submit")
    public WebElement loginButton;


    public void login(String userType){
        usernameBox.sendKeys(ConfigurationReader.getProperties(userType));
        passwordBox.sendKeys(ConfigurationReader.getProperties("Password"));
    }




}
