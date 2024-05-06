package com.nopcommerce.user;

import com.beust.jcommander.Parameter;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Function_01_Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String firstName, lastName, email,password;

    public HomePageObject getHomePage() {
        return homePage;
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName){
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
        password="123456";
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Register_01_Empty_Data(){
        log.info("Register 01 - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register 01 - Step 02: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Register 01 - Step 03: Verify error message at First Name Textbox");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
        log.info("Register 01 - Step 04: Verify error message at Last Name Textbox");
        Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
        log.info("Register 01 - Step 05: Verify error message at Email Textbox");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
        log.info("Register 01 - Step 06: Verify error message at Password Textbox");
        //Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
        log.info("Register 01 - Step 07: Verify error message at Confirm Password Textbox");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
    }
    @Test
    public void Register_02_Invalid_Email(){
        log.info("Register 02 - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register 02 - Step 02: input to First Name Textbox");
        registerPage.inputToFirstNameTextbox(firstName);
        log.info("Register 02 - Step 03: input to Last Name Textbox");
        registerPage.inputToLastNameTextbox(lastName);
        log.info("Register 02 - Step 04: input to Email Textbox");
        registerPage.inputToEmailTextbox("1234@@123$$");
        log.info("Register 02 - Step 05: input to Password Textbox");
        registerPage.inputToPasswordTextbox(password);
        log.info("Register 02 - Step 06: input to Confirm Password Textbox");
        registerPage.inputToConfirmPasswordTextbox(password);
        log.info("Register 02 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Register 02 - Step 08: Verify error message at Email Textbox");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Please enter a valid email address.");
    }
    @Test
    public void Register_03_Correct_Data(){
        log.info("Register 03 - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register 03 - Step 02: input to First Name Textbox");
        registerPage.inputToFirstNameTextbox(firstName);
        log.info("Register 03 - Step 03: input to Last Name Textbox");
        registerPage.inputToLastNameTextbox(lastName);
        log.info("Register 03 - Step 04: input to Email Textbox");
        registerPage.inputToEmailTextbox(email);
        log.info("Register 03 - Step 05: input to Password Textbox");
        registerPage.inputToPasswordTextbox(password);
        log.info("Register 03 - Step 06: input to Confirm Password Textbox");
        registerPage.inputToConfirmPasswordTextbox(password);
        log.info("Register 03 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Register 03 - Step 08: Verify Success message");
        Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(),"Your registration completed");
        //log.info("Register 03 - Step 09: Click Continue button");
        //homePage= registerPage.clickToContinueButton();
        log.info("Register 03 - Step 09: Click Login link");
        homePage= registerPage.clickToLoginLink();
    }
    @Test
    public void Register_04_Exiting_Email(){
        log.info("Register 04 - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register 04 - Step 02: input to First Name Textbox");
        registerPage.inputToFirstNameTextbox(firstName);
        log.info("Register 04 - Step 03: input to Last Name Textbox");
        registerPage.inputToLastNameTextbox(lastName);
        log.info("Register 04 - Step 04: input to Email Textbox");
        registerPage.inputToEmailTextbox(email);
        log.info("Register 04 - Step 05: input to Password Textbox");
        registerPage.inputToPasswordTextbox(password);
        log.info("Register 04 - Step 06: input to Confirm Password Textbox");
        registerPage.inputToConfirmPasswordTextbox(password);
        log.info("Register 04 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Register 04 - Step 08: Verify error message at Register page");
        Assert.assertEquals(registerPage.getErrorMessageAtRegisterPage(),"The specified email already exists");

    }
    @Test
    public void Register_05_Password_Less_Than_6_Character(){
        log.info("Register 05 - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register 05 - Step 02: input to First Name Textbox");
        registerPage.inputToFirstNameTextbox(firstName);
        log.info("Register 05 - Step 03: input to Last Name Textbox");
        registerPage.inputToLastNameTextbox(lastName);
        log.info("Register 05 - Step 04: input to Email Textbox");
        registerPage.inputToEmailTextbox(email);
        log.info("Register 05 - Step 05: input to Password Textbox");
        registerPage.inputToPasswordTextbox("1234");
        log.info("Register 05 - Step 06: input to Confirm Password Textbox");
        registerPage.inputToConfirmPasswordTextbox("1234");
        log.info("Register 05 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Register 05 - Step 08: Verify error message at Password Textbox");
        //Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");

    }
    @Test
    public void Register_06_Confirm_Password_Incorrect(){
        log.info("Register 06 - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register 06 - Step 02: input to First Name Textbox");
        registerPage.inputToFirstNameTextbox(firstName);
        log.info("Register 06 - Step 03: input to Last Name Textbox");
        registerPage.inputToLastNameTextbox(lastName);
        log.info("Register 06 - Step 04: input to Email Textbox");
        registerPage.inputToEmailTextbox(email);
        log.info("Register 06 - Step 05: input to Password Textbox");
        registerPage.inputToPasswordTextbox(password);
        log.info("Register 06 - Step 06: input to Confirm Password Textbox");
        registerPage.inputToConfirmPasswordTextbox("666666");
        log.info("Register 06 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();
        log.info("Register 06 - Step 08: Verify error message at Confirm Password Textbox");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }


}
