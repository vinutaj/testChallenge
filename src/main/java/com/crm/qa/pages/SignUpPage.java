package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

    @FindBy(id = "uname")
    WebElement username;

    @FindBy(id = "pwd")
    WebElement password;

    @FindBy(id = "psw-repeat")
    WebElement repeatPassword;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    WebElement cancelBtn;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    //Initializing the Page Objects:
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateSignUpPageTitle() {
        return driver.getTitle();
    }

    public LoginPage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        repeatPassword.sendKeys(pwd);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signUpBtn);

        return new LoginPage();
    }

    public HomePage cancelSignUp(){
        cancelBtn.click();
        return new HomePage();
    }


}


