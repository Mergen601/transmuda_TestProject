package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }


    /*
    We make webdriver private,  because we want to close access from outside of the class.
     */
    private static WebDriver driver;


    /*
    Creage re-useable method which will return same driver instance when we call it
     */
    public static WebDriver getDriver() {

        if (driver == null) {


            // we read ou browsertype from configuration.properties
            String browserType = ConfigurationReader.getProperties("browser");

            switch (browserType) {

                /* Depending on the browsertype that will be return from configuration.properties file switch statement
                will determine the cacse, and open the matching browser.*/

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


            }

        }

        return driver;


    }

    public  static void closeDriver(){

        if (driver != null){
            driver.quit();
            driver=null;
        }

    }
}
