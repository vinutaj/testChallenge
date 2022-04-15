package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        HomePageTest homePageTest = new HomePageTest();
        homePageTest.verifyHomePageTest();
    }


    @Test(priority = 3)
    public void loginTest() {
        loginPage = homePage.clickLoginButton();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
