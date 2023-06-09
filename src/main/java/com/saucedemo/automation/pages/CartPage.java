package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CartPage {
    @FindBy(id = "shopping_cart_container")
    public WebElement btnCart;


    @FindBy(id="continue-shopping")
    private WebElement continueShoppingBtn;


    private  WebDriver driver;

    public CartPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean proceedToCheckOutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        boolean displayProceedToCheckOut=driver.findElement(By.id("checkout")).isDisplayed();
        return displayProceedToCheckOut;
    }

    public boolean continueToShoppingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue-shopping")));
        boolean displayContinueToShopping=driver.findElement(By.id("continue-shopping")).isDisplayed();
        return displayContinueToShopping;
    }



}