package com.allianz.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WebDriverKeywords {
    protected WebDriver driver;
    public WebDriverKeywords (WebDriver driver){
        this.driver = driver;
    }
    public void setInputText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);

    }
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getAttributValue(By locator, String attributeName) {
        return driver.findElement(locator).getAttribute(attributeName);
    }
    public void switchtTabByTitle(String title) {
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

        for (String win : windows) {
            driver.switchTo().window(win);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }


}
