package com.webautomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;
    
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement userPassword;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void login(String email, String password) throws InterruptedException {
        username.sendKeys(email);
        userPassword.sendKeys(password);
        Thread.sleep(2000);
        loginBtn.click();
    }
}

