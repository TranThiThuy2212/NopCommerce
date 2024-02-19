package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Function_02_Login extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;

    private String firstName, lastName, email,password, emailNotFound;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName){
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
        emailNotFound="thuy1234"+ganarateNumber()+"@gmail.com";
        password="123456";
        homePage = PageGeneratorManager.getHomePage(driver);
        log.info("Pre-Condition - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Pre-Condition - Step 02: input to First Name Textbox");
        registerPage.inputToFirstNameTextbox(firstName);
        log.info("Pre-Condition - Step 03: input to Last Name Textbox");
        registerPage.inputToLastNameTextbox(lastName);
        log.info("Pre-Condition - Step 04: input to Email Textbox");
        registerPage.inputToEmailTextbox(email);
        log.info("Pre-Condition - Step 05: input to Password Textbox");
        registerPage.inputToPasswordTextbox(password);
        log.info("Pre-Condition - Step 06: input to Confirm Password Textbox");
        registerPage.inputToConfirmPasswordTextbox(password);
        log.info("Pre-Condition - Step 07: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Pre-Condition - Step 08: Verify Success message");
        Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(),"Your registration completed");
        log.info("Pre-Condition - Step 09: Click Continue button");
        homePage= registerPage.clickToContinueButton();
    }

    @Test
    public void Login_01_Empty_Data(){
        log.info("Login_01 - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Login_01 - Step 02: Click to Login button");
        loginPage.clickToLoginButton();
        log.info("Login_01 - Step 03: Verify error message at Email textbox");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
    }
    @Test
    public void Login_02_Invalid_Email(){
        log.info("Login_02 - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Login_02 - Step 02: input to Email textbox");
        loginPage.inputToEmailTextbox("123##$1234");
        log.info("Login_02 - Step 03: Click to Login button");
        loginPage.clickToLoginButton();
        log.info("Login_02 - Step 04: Verify error message at Email textbox");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }
    @Test
    public void Login_03_Email_Not_Found(){
        log.info("Login_03 - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Login_03 - Step 02: input to Email textbox");
        loginPage.inputToEmailTextbox(emailNotFound);
        log.info("Login_03 - Step 03: input to Password textbox");
        loginPage.inputToPasswordTextbox(password);
        log.info("Login_03 - Step 04: Click to Login button");
        loginPage.clickToLoginButton();
        log.info("Login_03 - Step 05: Verify error message at Login page");
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }
    @Test
    public void Login_04_Email_Exiting_Empty_Password(){
        log.info("Login_04 - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Login_04 - Step 02: input to Email textbox");
        loginPage.inputToEmailTextbox(email);
        log.info("Login_04 - Step 03: input to Password textbox");
        loginPage.inputToPasswordTextbox("");
        log.info("Login_04 - Step 04: Click to Login button");
        loginPage.clickToLoginButton();
        log.info("Login_04 - Step 05: Verify error message at Login page");
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_05_Email_Exiting_Incorrect_Password(){
        log.info("Login_05 - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Login_05 - Step 02: input to Email textbox");
        loginPage.inputToEmailTextbox(email);
        log.info("Login_05 - Step 03: input to Password textbox");
        loginPage.inputToPasswordTextbox("666666");
        log.info("Login_05 - Step 04: Click to Login button");
        loginPage.clickToLoginButton();
        log.info("Login_05 - Step 05: Verify error message at Login page");
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_06_Email_Exiting_Correct_Password(){
        log.info("Login_06 - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Login_06 - Step 02: input to Email textbox");
        loginPage.inputToEmailTextbox(email);
        log.info("Login_06 - Step 03: input to Password textbox");
        loginPage.inputToPasswordTextbox(password);
        log.info("Login_06 - Step 04: Click to Login button");
        homePage=loginPage.clickToLoginButton();
        log.info("Login_06 - Step 05: Verify My Account link display");
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
