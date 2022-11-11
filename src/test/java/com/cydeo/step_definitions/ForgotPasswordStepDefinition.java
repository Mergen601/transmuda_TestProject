package com.cydeo.step_definitions;

import com.cydeo.pages.ForgotPasswordPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Properties;

public class ForgotPasswordStepDefinition {

    LoginPage loginPage = new LoginPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();


    @When("I click on the Forgot Password link")
    public void ı_click_on_the_forgot_password_link() {
         loginPage.forgotYourPasswordLink.click();
    }
    @Then("I should be on the Forgot Password page")
    public void ı_should_be_on_the_forgot_password_page() {
       BrowserUtils.verifyTitle("Forgot Password");
    }

    @Given("I am on the Forgot Password page")
    public void ıAmOnTheForgotPasswordPage() {
        BrowserUtils.verifyUrl(ConfigurationReader.getProperties("ForgotPasswordUrl"));

    }

    @When("I enter username {string} and click on Request button")
    public void ıEnterUsernameAndClickOnRequestButton(String username) {
        forgotPasswordPage.usernameOrMailInput.sendKeys(username);
        forgotPasswordPage.requestExtraSubmitButton.click();
    }

    @Then("I should see the error message {string}")
    public void ıShouldSeeTheErrorMessage(String errorMessage) {
        forgotPasswordPage.verifyErrorMessage(errorMessage);
    }
}
