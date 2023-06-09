package com.saucedemo.automation.TestSuite;

import com.saucedemo.automation.base.TestBase;
import com.saucedemo.automation.pages.CartPage;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.pages.ProductsPage;
import com.saucedemo.automation.utils.Utils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartPageTest extends TestBase {

    CartPage cartPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    Utils utils=new Utils();

    @Step("Test case 004")
    @Test(priority = 1,description = "Add items to Cart")
    public void addItemsToCart() throws InterruptedException, IOException, ParseException {
        driver.get("https://www.saucedemo.com/");
        loginPage=new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(0);
        boolean isLogIn=loginPage.doLoginWithValidCredential(utils.getUsername(), utils.getPassword());
        productsPage=new ProductsPage(driver);
        boolean badgeDisplay=productsPage.displayCartBadge();
        org.testng.Assert.assertTrue(badgeDisplay);
        Allure.description("By adding item on chart, the badge will be displayed with the number of the items added");
    }
    @Step("Test case 005")
    @Test(priority = 2,description = "ProceedToCheckOut button will be displayed")
    public void proceedToCheckOutButton() throws InterruptedException, IOException {
        productsPage=new ProductsPage(driver);
        productsPage.clickToCart();
        cartPage=new CartPage(driver);
        boolean displayProceedToCheckOutButton= cartPage.proceedToCheckOutButton();
        org.testng.Assert.assertTrue(displayProceedToCheckOutButton);
        Allure.description("Proceed To CheckOut button should be displayed after adding an item to cart");
    }
    @Step("Test case 006")
    @Test(priority = 3,description = "Continue To Shopping button will be displayed")
    public void continueToShoppingButton() throws InterruptedException, IOException {
        cartPage=new CartPage(driver);
        boolean displayContinueToShoppingButton= cartPage.continueToShoppingButton();
        org.testng.Assert.assertTrue(displayContinueToShoppingButton);
        Allure.description("Continue To Shopping button should be displayed after adding to cart");
    }
    }
