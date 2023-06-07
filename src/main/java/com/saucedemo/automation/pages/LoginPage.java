package com.saucedemo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.automation.base.TestBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends TestBase{

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    private WebElement wrongUserAndPass;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    private WebElement emptyPassErrorMessage;


    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    private WebElement emptyUserErrorMessage;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    private WebElement invalidCredentialsErrorMessage;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    private WebDriver driver;

    public LoginPage(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public String getLoginPageTitle() {
        return driver.getTitle();
    }


    public Boolean doLoginWithValidCredential(String user, String pwd) throws InterruptedException {
        username.clear();
        password.clear();
        username.sendKeys(user);
        Thread.sleep(1000);
        password.sendKeys(pwd);
        loginBtn.click();
        Thread.sleep(1000);
        return shoppingCart.isDisplayed();
    }

    public String doLoginWithInvalidCredential(String user, String pwd) throws InterruptedException {
        username.clear();
        password.clear();
        username.sendKeys(user);
        Thread.sleep(1000);
        password.sendKeys(pwd);
        loginBtn.click();
        Thread.sleep(1000);
        return invalidCredentialsErrorMessage.getText();
    }


    public String doLoginWithEmptyUser(String user, String pwd) throws InterruptedException {
        username.clear();
        username.sendKeys(user);
        Thread.sleep(1000);
        password.sendKeys(pwd);
        loginBtn.click();
        return emptyUserErrorMessage.getText();
    }

    public String doLoginWithEmptyPass(String user, String pwd) throws InterruptedException {
        password.clear();
        password.sendKeys(pwd);
        Thread.sleep(1000);
        username.sendKeys(user);
        loginBtn.click();
        return emptyPassErrorMessage.getText();
    }

}
