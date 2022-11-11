package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RememberMeStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("I click on Remember me checkbox")
    public void i_click_on_remember_me_checkbox() {
       loginPage.rememberMeCheckBox.click();

    }


    @Then("Remember me checkbox should be checked")
    public void rememberMeCheckboxShouldBeChecked() {
        Assert.assertTrue(loginPage.rememberMeCheckBox.isSelected());
    }
}
