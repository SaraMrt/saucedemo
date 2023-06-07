package com.saucedemo.automation.TestSuit;

import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.base.TestBase;
import com.saucedemo.automation.utils.Utils;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    Utils utils=new Utils();

    public LoginPageTest() throws IOException {
    }

    @Test(priority=9,description = "User gives valid credentials and login is successful")
    public void doLoginWithValidCredential() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(0);
        driver.get("https://www.saucedemo.com/");
        boolean isLogOutFound=loginPage.doLoginWithValidCredential(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(isLogOutFound,true);
        Allure.description("After giving valid credentials of the user, user will be able to successfully login " +
                "and after login cart icon will be displayed up on right corner");
    }
    @Test(priority = 1,description = "Empty User")
    public void doLoginWithEmptyUser() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils.getUserCreds(0);
        driver.get("https://www.saucedemo.com/");
        String validationMessage=loginPage.doLoginWithEmptyUser("", utils.getPassword());
        Assert.assertTrue(validationMessage.contains("Epic sadface: Username is required"));
        Allure.description("Username field is empty");
    }
    @Test(priority = 2,description = "Empty Password")
    public void doLoginWithEmptyPass() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        utils.getUserCreds(0);
        driver.get("https://www.saucedemo.com/");
        String validationMessage=loginPage.doLoginWithEmptyPass (utils.getUsername(), "");
        Assert.assertTrue(validationMessage.contains("Epic sadface: Password is required"));
        Allure.description("Password field is empty");
    }
    @Test(priority = 3,description = "User tries to login with invalid credentials")
    public void doLoginWithInvalidCredential() throws IOException, ParseException, InterruptedException {
        loginPage=new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        utils.getUserCreds(1);
        String validationMessage=loginPage.doLoginWithInvalidCredential(utils.getUsername(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("Epic sadface: Username and password do not match any user in this service"));
        Allure.description("User tries to login with invalid credentials");
    }

}

