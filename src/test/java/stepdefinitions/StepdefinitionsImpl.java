package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.webautomation.pageobject.CartPage;
import com.webautomation.pageobject.Confrimation;
import com.webautomation.pageobject.LandingPage;
import com.webautomation.pageobject.OrderPage;
import com.webautomation.pageobject.ProductListPage;

import components.BaseTest;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionsImpl extends BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    //tugas
    @Given("Buyer landing to saucedemo")
    public void landingPage() throws IOException{
        //setup driver
        driver = Hooks.initializeDriver();
    }

    @Given("^Buyer login to the saucedemo username (.+) and password (.+)$")
    public void buyerLogin(String username, String password) throws InterruptedException{
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(username, password);
    }

    @When("^Buyer add a saucedemo product (.+) and (.+) to the cart$")
    public void addProductToCartdua(String productname, String productname2) throws InterruptedException{
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productname);
        productListPage.addToCart(productname2);
        driver.findElement(By.cssSelector(".shopping_cart_container a.shopping_cart_link")).click();
    }

    @And("^Buyer checkout saucedemo product (.+) and (.+)$")
    public void checkoutDuaProduct(String productname, String productname2) throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname));
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname2));
        cartPage.checkout();
    }

    @And("^Buyer insert (.+) (.+) (.+) for shipping$")
    public void placeOrder(String firstName, String lastName, String postalCode) throws InterruptedException {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, postalCode);
    }

    @And("^Buyer will see checkout overview (.+)$")
    public void CheckoutOverview(String succesCheckout) throws InterruptedException{
        Confrimation confirmationPage = new Confrimation(driver);
        confirmationPage.finish();
    }

    @Then("^Buyer will see message confirmation page (.+)$")
    public void messageConfirmation(String terimaKasih){
        Confrimation confirmationPage = new Confrimation(driver);
        String confirmationText = confirmationPage.verifyConfirmation();
        Assert.assertEquals(confirmationText, terimaKasih);
    }

    
    @When("^Buyer add a product (.+) to the cart$")
    public void addProductToCartsatu(String productname) throws InterruptedException {
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productname);
        driver.findElement(By.cssSelector(".shopping_cart_container a.shopping_cart_link")).click();
    }

    @And("^Buyer checkout product (.+)$")
    public void checkoutSatuProduct(String productname) throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname));
        cartPage.checkout();
    }
}

