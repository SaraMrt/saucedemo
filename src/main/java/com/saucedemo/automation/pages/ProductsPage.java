package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.TestBase;
import com.saucedemo.automation.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class ProductsPage {

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement btnAddToCart1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement btnAddToCart2;


    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public CartPage clickToCart() throws IOException {
        SeleniumHelper.waitForElementToBeClickable(driver, shoppingCart);
        shoppingCart.click();
        return new CartPage(driver);
    }


    public boolean displayCartBadge() {
        SeleniumHelper.waitForElementToBeClickable(driver, btnAddToCart1);
        btnAddToCart1.click();
        SeleniumHelper.waitForElementToBeClickable(driver, btnAddToCart2);
        btnAddToCart2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        boolean cartBadge=driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        return cartBadge;
    }

}
