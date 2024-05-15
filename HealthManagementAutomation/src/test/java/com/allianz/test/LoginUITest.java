package com.allianz.test;

import com.allianz.base.AutomationWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginUITest extends AutomationWrapper {

    @Test(groups = {"ui","smoke"})
    public void titleTest(){

       String actualTitle=driver.getTitle();
       Assert.assertEquals(actualTitle,"OrangeHRM");

    }
    @Test(groups = {"ui"})
    public void applicationDescriptionTest()
    {

        String actualTitle=driver.getTitle();
        String actualText=driver.findElement(By.xpath("//p[text()='OrangeHRM OS 5.6.1']")).getText();
        Assert.assertEquals(actualText,"OrangeHRM OS 5.6.1");

    }
}
