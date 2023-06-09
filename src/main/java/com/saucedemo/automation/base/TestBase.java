package com.saucedemo.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.saucedemo.automation.utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class TestBase {

   public WebDriver driver;
    @BeforeClass
    public void setUp() throws IOException{
        System.setProperty("webdriver.chrome.driver","src/main/java/com/saucedemo/automation/config/chromedriver.exe");
        ChromeOptions ops=new ChromeOptions();
        ops.addArguments("--headed");
        driver=new ChromeDriver(ops);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void screenShot(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                Utils utils=new Utils();
                utils.takeScreenshot(driver);
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}