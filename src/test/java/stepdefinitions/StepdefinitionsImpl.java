package stepdefinitions;

import java.io.IOException;

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
        productListPage.goToCart();
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

    @And("^Buyer will see checkout overview p1 (.+) and p2 (.+) on the page$")
    public void CheckoutOverview(String productname, String productname2) throws InterruptedException{
        Confrimation confirmationPage = new Confrimation(driver);
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname));
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname2));
        confirmationPage.finish();
    }

    @Then("^Buyer will see message confirmation page (.+)$")
    public void messageConfirmation(String terimaKasih){
        Confrimation confirmationPage = new Confrimation(driver);
        String confirmationText = confirmationPage.verifyConfirmation();
        Assert.assertEquals(confirmationText, terimaKasih);
    }

    //scenario one product
    @When("^Buyer add a product (.+) to the cart$")
    public void addProductToCartsatu(String productname) throws InterruptedException {
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productname);
        productListPage.goToCart();
    }

    @And("^Buyer checkout product (.+)$")
    public void checkoutSatuProduct(String productname) throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname));
        cartPage.checkout();
    }

    @And("^Buyer will see checkout overview (.+)$")
    public void CheckoutOneProduct(String productname) throws InterruptedException{
        Confrimation confirmationPage = new Confrimation(driver);
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname));
        confirmationPage.finish();
    }

    //scenario change product
    //Buyer remove product1 <productname> from the cart

    @And("^Buyer checkout product1 (.+)$")
    public void checkoutnwProduct(String productname) throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname));
    }
    @And("^Buyer remove product1 (.+) from the cart$")
    public void removeProduct(String productname){
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.removeProduct(productname);
    }

    @And("^Buyer back to home to change product$")
    public void backToHome(){
        CartPage cartPage = new CartPage(driver);
        cartPage.goToProductList();
    }
    @And("^Buyer add a new product (.+) to the cart$")
    public void addProductBaru(String productname2) throws InterruptedException {
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productname2);
        productListPage.goToCart();
    }

    @And("^Buyer checkout new product (.+)$")
    public void checkoutnewProduct(String productname2) throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname2));
        cartPage.checkout();
    }

    @And("^Buyer see checkout overview new product (.+)$")
    public void ChecknewProduct(String productname2) throws InterruptedException{
        Confrimation confirmationPage = new Confrimation(driver);
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productname2));
        confirmationPage.finish();
    }
}

