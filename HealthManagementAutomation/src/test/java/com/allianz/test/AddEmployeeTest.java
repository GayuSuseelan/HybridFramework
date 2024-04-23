package com.allianz.test;

import com.allianz.base.AutomationWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AddEmployeeTest extends AutomationWrapper {
    @Test
    public void uploadInvalidDisplayPics() throws InterruptedException {
        File file=new File("src/test/resources/Files/Xpath.text");
        String path= file.getAbsolutePath();

            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            driver.findElement(By.xpath("//span[text()='PIM']")).click();
            driver.findElement(By.linkText("Add Employee")).click();
            driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);
        String actualError=driver.findElement(By.xpath("//span[contains(normalize-space(),'File type')]")).getText();
        Assert.assertTrue(actualError.contains("File type not allowed"));  //expect true

            //click on PIM menu
            //click on add employee
            //upload the pdf file instead of image
            //Assert the error - File type not allowed
        }

    }


