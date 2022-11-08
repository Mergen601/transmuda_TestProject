package com.cydeo.step_definitions;


import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void ı_am_on_the_login_page() {
        Driver.getDriver().get("https://qa.transmuda.com");
    }
    @When("I enter {string} username and password")
    public void ı_enter_username_and_password(String userType) {
        loginPage.loginWithUserType(userType);

    }
    @And("I click on the login button")
    public void ı_click_on_the_login_button() {
        loginPage.loginButton.click();
        BrowserUtils.sleep(3);
    }
    @Then("I should be logged in")
    public void ı_should_be_logged_in() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("Dashboard"));
    }
}
