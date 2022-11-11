package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        /*
        This method willa accept int (in seconds) adn execute Thread.sleep
        for given duration
         */
        second*=1000;
        try{
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method accepts 3 arguments:
    Arg1: webDriver
    Arg2: expectedUrl: for verify if the Url contains given String
            - If conditions matches , will break loop
    Arg3 : expectedTitle to bea compared against actual tile
     */
    public static void switchWindowAndVerify( String expectedUrl, String expectedTitle){

        Set<String> windowHandles= Driver.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);

            if(Driver.getDriver().getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        //5. Assert: Title contains “Etsy”

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    /*
    This method accepts a String "ExpectedTitle" and Asserts if it is true
     */

    public static void verifyTitle( String expectedTitle)
    {
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    /*This method will accept dropdown as a WebElement
     * and return all the options as String
     * @parameter dropdownElement
     * @Return
     */
    public static List<String> dropOptionsAsString(WebElement dropdownOptions){

        Select select = new Select(dropdownOptions);
        List<WebElement> actualOptions =   select.getOptions();
        ArrayList<String> optionsAsString = new ArrayList<>();

        for(WebElement each : actualOptions){
            optionsAsString.add(each.getText());

        }

        return optionsAsString;

    }


    // #1 This method will accep expectedUrl as a String and verify if it is true
    // #2 @parameter expectedUrl
    public static void verifyUrl(String expectedUrl){
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }


}
