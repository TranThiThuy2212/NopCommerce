package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Function_06_Display_Paging extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private ComputersPageObject computersPage;
    private NotebooksPageObject notebooksPage;
    private String firstName, lastName, email,password;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName) {
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
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
        log.info("Pre-Condition - Step 10: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("Pre-Condition - Step 11: input to Email textbox");
        loginPage.inputToEmailTextbox(email);
        log.info("Pre-Condition - Step 12: input to Password textbox");
        loginPage.inputToPasswordTextbox(password);
        log.info("Pre-Condition - Step 13: Click to Login button");
        homePage=loginPage.clickToLoginButton();
        log.info("Pre-Condition - Step 14: Verify My Account link display");
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
        log.info("Pre-Condition - Step 15: Click to Computer link");
        computersPage=homePage.clickToComputerLink();
        log.info("Pre-Condition - Step 16: Click to Notebooks link");
        notebooksPage =computersPage.clickToNotebooksLink();
    }
    @Test
    public void Display_01_3_Product(){
        log.info("DisPlay_01 - Step 01: Click to item in Display Dropdown");
        notebooksPage.selectItemNumberProductDisplayDropDown("3");
        notebooksPage.sleepInSecond(2);
        log.info("DisPlay_01 - Step 02: Verify number product display ");
        Assert.assertEquals(notebooksPage.numberOfProductShow(),3);
        log.info("DisPlay_01 - Step 03: Verify Page one display");
        Assert.assertTrue(notebooksPage.isPageOneDisplay());
        log.info("DisPlay_01 - Step 04: Verify Next icon display");
        Assert.assertTrue(notebooksPage.isNextIconDisplay());
        log.info("DisPlay_01 - Step 05: Click to Page two display");
        notebooksPage.clickToPageTwo();
        log.info("DisPlay_01 - Step 06: Verify Previous icon display");
        Assert.assertTrue(notebooksPage.isPreviousIconDisplay());
    }
    @Test
    public void Display_02_6_Product(){
        log.info("DisPlay_02 - Step 01: Click to item in Display Dropdown");
        notebooksPage.selectItemNumberProductDisplayDropDown("6");
        notebooksPage.sleepInSecond(2);
        log.info("DisPlay_02 - Step 02: Verify number product display ");
        Assert.assertEquals(notebooksPage.numberOfProductShow(),6);
        log.info("DisPlay_02 - Step 03: Verify pagging one display");
        Assert.assertTrue(notebooksPage.isPaggingUnDisplay());
    }
    @Test
    public void Display_03_9_Product(){
        log.info("DisPlay_03 - Step 01: Click to item in Display Dropdown");
        notebooksPage.selectItemNumberProductDisplayDropDown("9");
        notebooksPage.sleepInSecond(2);
        log.info("DisPlay_03 - Step 02: Verify number product display ");
        Assert.assertEquals(notebooksPage.numberOfProductShow(),6);
        log.info("DisPlay_03 - Step 03: Verify pagging one display");
        Assert.assertTrue(notebooksPage.isPaggingUnDisplay());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
