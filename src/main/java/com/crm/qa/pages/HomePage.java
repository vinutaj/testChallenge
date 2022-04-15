package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerBtn;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    public WebElement loginBtn;

    @FindBy(xpath = "//img[contains(@class,'centered responsive')]")
    public WebElement appLoginImage;

    @FindBy(xpath = "//a[@href='https://github.com/users/ale-sanchez-g/projects/1']")
    public WebElement moreInfoLink;

    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean validateImage() {
        return appLoginImage.isDisplayed();
    }

    public void clickMoreInfoLink() {
        moreInfoLink.click();
    }

    public LoginPage clickLoginButton() {
        loginBtn.click();
        return new LoginPage();
    }

    public SignUpPage clickRegisterButton() {
        registerBtn.click();
        return new SignUpPage();
    }


}
