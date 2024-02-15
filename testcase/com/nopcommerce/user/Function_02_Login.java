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

        registerPage = homePage.clickToRegisterLink();
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(email);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(),"Your registration completed");
        homePage= registerPage.clickToContinueButton();
    }

    @Test
    public void Login_01_Empty_Data(){
        loginPage = homePage.clickToLoginLink();
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
    }
    @Test
    public void Login_02_Invalid_Email(){
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox("123##$1234");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }
    @Test
    public void Login_03_Email_Not_Found(){
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(emailNotFound);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }
    @Test
    public void Login_04_Email_Exiting_Empty_Password(){
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_05_Email_Exiting_Incorrect_Password(){
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox("666666");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_06_Email_Exiting_Correct_Password(){
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        homePage=loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
