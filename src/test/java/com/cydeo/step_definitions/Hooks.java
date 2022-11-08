package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
     /* In the class we will be able to pass pre&post conditions
    to each scenario and steps */

    @Before
    public void setupScenario(){

        System.out.println("===Setting up browser using cucumber");
    }

    @After()
    public void tearDownScenario(Scenario scenario) {
        System.out.println("===Closing browser using cucumber");
        System.out.println("==Scenario ended/ Take screenshot if failed!");

        if (scenario.isFailed()) {


            byte screenShot[] = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenShot, "image/png", scenario.getName());

        }
        Driver.closeDriver();



    }

    @BeforeStep
    public void setupStep(){
        System.out.println("----------------------Applying setup-----------------");
    }


    @AfterStep
    public void tearDownStep(){
        System.out.println("----------------------Applying teardown--------------------");
    }
}
