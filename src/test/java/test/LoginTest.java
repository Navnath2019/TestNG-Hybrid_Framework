package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import base.Base;
import page.LoginPage;

public class LoginTest extends LoginPage {
	
	LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws IOException {
        base(); // This will initialize the browser and open the URL
//        
    }

    @Test
    public void loginTest() {
    	loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        loginPage.getTextAfterLogin();
    }


@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}
//	 LoginPage lp;
//
//	    @BeforeMethod
//	    public void init() throws IOException {
//	        base();
//	        lp = new LoginPage();
//	        lp.driver = this.driver;
//	        lp.locators = this.locators;
//	        lp.testData = this.testData;
//	    }
//
//	    @Test
//	 public void login() {
//	    	LoginTest lt = new LoginTest();
//	        lt.enterUsername();
//	        lt.enterPassword();
//	        lt.clickLoginButton();
//	    }
//
//	    @AfterMethod
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
//	}