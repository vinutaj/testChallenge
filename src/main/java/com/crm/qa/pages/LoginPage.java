package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="worrior_username")
	WebElement username;
	
	@FindBy(id="worrior_pwd")
	WebElement password;
	
	@FindBy(xpath="//a[@class='btn'][text()='Login warrior']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	

	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}

	public HomePage cancelSignUp(){
		cancelBtn.click();
		return new HomePage();
	}
	
}
