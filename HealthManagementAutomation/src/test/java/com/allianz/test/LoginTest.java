package com.allianz.test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.DashboardPage;
import com.allianz.pages.LoginPage;
import com.allianz.utilities.DataUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AutomationWrapper {
    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class,groups = {"login","smoke"})
    public void validLoginTest(String username, String password, String expectedHeader) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        test.log(Status.INFO, "Entered username as "+username);
        loginPage.enterPassword(password);
        test.log(Status.INFO, "Entered password as "+password);
        loginPage.clickOnLogin();
        test.log(Status.INFO, "Clicked on login");

        DashboardPage dashboardPage=new DashboardPage(driver);
        String actualHeader = dashboardPage.getDashboardHeader();
        test.log(Status.INFO, "Actual header "+actualHeader);
        Assert.assertEquals(actualHeader, expectedHeader);
    }
    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class,groups = {"login","smoke"})
    public void invalidLoginTest(String username, String password, String expectedHeader    ) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();

        DashboardPage dashboardPage=new DashboardPage(driver);
        String actualHeader = dashboardPage.getDashboardHeader();
        Assert.assertEquals(actualHeader, expectedHeader);
    }


}
