package com.webautomation.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
    WebDriver driver;

    @FindBy(css = ".shopping_cart_container a.shopping_cart_link")
    WebElement cartButton;

    @FindBy(css = "#continue-shopping")
    WebElement backToHome;

    public AbstractComponent(WebDriver driver){
        this.driver = driver;
    }


    public void visibilityOfElementLocated(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void goToCart(){
        cartButton.click();
    }
    public void goToProductList(){
        backToHome.click();
    }
}

