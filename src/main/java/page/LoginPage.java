package page;

import org.testng.annotations.Test;

import base.CommonActions;

public class LoginPage extends CommonActions {

	 // Enter username
    public void enterUsername() {
        enterData("Username", "TestData1");
    }

    // Enter password
    public void enterPassword() {
        enterData("Password", "TestData2");
    }

    // Click login button
    public void clickLogin() {
        click("Login");
    }

    // Get text after login
    public void getTextAfterLogin() {
        getText("getText");
    }
    
    // Get text after login
    public void winHandle() {
        click("WinHandle");
        
    }
}

	