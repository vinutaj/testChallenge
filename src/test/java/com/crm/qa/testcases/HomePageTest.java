package com.crm.qa.testcases;

import com.crm.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SignUpPage signUpPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
		homePage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "COVID-19 THE GAME","Home page title not matched");
		Assert.assertTrue(homePage.validateImage(),"Home page image is not displayed");
		Assert.assertTrue(homePage.registerBtn.isEnabled(),"Register button is not enabled");
		Assert.assertTrue(homePage.loginBtn.isEnabled(),"Login button is not enabled");
		Assert.assertTrue(homePage.moreInfoLink.isEnabled(),"More Info link is not enabled");
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
