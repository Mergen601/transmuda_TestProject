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
import org.openqa.selenium.Keys;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    @Given("I am on the login page")
    public void ı_am_on_the_login_page() {
      Driver.getDriver().get("https://qa.transmuda.com");
    }
    @When("I enter vald {string} credentials")
    public void ı_enter_valid_credentials(String userType) {
        loginPage.loginWithUserType(userType);
    }
    @When("I should click on login button")
    public void ı_should_click_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("I should be logged in")
    public void ı_should_be_logged_in() {
        BrowserUtils.sleep(5);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }


    @When("I enter Invalid {string} and {string} credentials")
    public void ıEnterInvalidAndCredentials(String userName, String password) {
        loginPage.loginWithUsernameAndPassword(userName,password);
    }



    @Then("I should see {string}")
    public void ıShouldSee(String expectedErrorMessage) {

        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage,actualMessage);
    }

    @When("I enter empty {string} and {string} credentials")
    public void ıEnterEmptyAndCredentials(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("I should see {string} message")
    public void ıShouldSeeMessage(String validationMessage) {

        String actualValidationMessage = loginPage.passwordInput.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains(actualValidationMessage));

    }

    @When("I enter valid credentials")
    public void ıEnterValidCredentials() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperties("Driver"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperties("Password"));
    }

    @Then("I should see password in bullet signs")
    public void ıShouldSeePasswordInBulletSigns() {
        String actualType = loginPage.passwordInput.getAttribute("type");
        Assert.assertEquals("password",actualType);

    }


}
