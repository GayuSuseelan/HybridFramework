package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebDriverKeywords {
    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginLocator = By.xpath("//button[normalize-space()='Login']");
    private By errorLocator = By.xpath("//p[contains(normalize-space(),'Invalid')]");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void enterUsername(String username) {
        // this.driver.findElement(usernameLocator).sendKeys(username);
        super.setInputText(usernameLocator, username);
    }

    public void enterPassword(String password) {
//		driver.findElement(passwordLocator).sendKeys(password);
        setInputText(passwordLocator, password);
    }

    public void clickOnLogin() {
//		driver.findElement(loginLocator).click();
        clickElement(loginLocator);
    }
    public String getInvalidErrorMessage() {
        //return driver.findElement(errorLocator).getText();
        return super.getText(errorLocator);
    }

    public String getUsernamePlaceholder() {
        //return driver.findElement(usernameLocator).getAttribute("placeholder");
        return getAttributValue(usernameLocator, "placeholder");
    }

    public String getPasswordPlaceholder() {
        //return driver.findElement(passwordLocator).getAttribute("placeholder")
        return getAttributValue(passwordLocator, "placeholder");
    }
    // getHeader()
    // clickOnForgotPassword()


}

