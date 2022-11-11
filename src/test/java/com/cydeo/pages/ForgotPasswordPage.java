package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//fieldset/input")
    public WebElement usernameOrMailInput;

    @FindBy(xpath = "//button")
    public WebElement requestExtraSubmitButton;

    @FindBy(xpath = "//div[@class=\"alert alert-warn\"]")
    public WebElement unableToSendEmail;

    @FindBy(xpath = "//div[contains(@class, \"alert\")]")
    public WebElement thereIsNoActive;

    public void verifyErrorMessage(String expectedMessage) {
        if (expectedMessage.contains("Unable to send the email.")) {
            Assert.assertTrue(unableToSendEmail.getText().contains(expectedMessage));
        } else if (expectedMessage.contains("There is no active user with username or e-mail address provided.")) {
            //verify thereIsNoActive
            Assert.assertTrue(thereIsNoActive.getText().contains(expectedMessage));
        }
        else {
            Assert.fail("No such error message");
        }
    }


}
