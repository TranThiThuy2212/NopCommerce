package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Function_05_Sort extends BaseTest {
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
        //log.info("Pre-Condition - Step 09: Click Continue button");
        //homePage= registerPage.clickToContinueButton();
        log.info("Pre-Condition - Step 09: Click Login link");
        homePage= registerPage.clickToLoginLink();
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
    public void Sort_01_Sort_By_Name_ASC(){
        log.info("Sort_01 - Step 01: Click to item in Sort Dropdown");
        notebooksPage.selectItemProductSortDropDown("Name: A to Z");
        notebooksPage.sleepInSecond(2);
        log.info("Sort_01 - Step 02: Verify sort by name ASC ");
        Assert.assertTrue(notebooksPage.isProductSortByNameASC());
    }
    @Test
    public void Sort_02_Sort_By_Name_DESC(){
        log.info("Sort_02 - Step 01: Click to item in Sort Dropdown");
        notebooksPage.selectItemProductSortDropDown("Name: Z to A");
        notebooksPage.sleepInSecond(2);
        log.info("Sort_02 - Step 02: Verify sort by name DESC ");
        Assert.assertTrue(notebooksPage.isProductSortByNameDEC());
    }
    @Test
    public void Sort_03_Sort_By_Price_ASC(){
        log.info("Sort_03 - Step 01: Click to item in Sort Dropdown");
        notebooksPage.selectItemProductSortDropDown("Price: Low to High");
        notebooksPage.sleepInSecond(2);
        log.info("Sort_03 - Step 02: Verify sort by price ASC ");
        Assert.assertTrue(notebooksPage.isProductSortByPriceASC());
    }
    @Test
    public void Sort_04_Sort_By_Price_DESC(){
        log.info("Sort_04 - Step 01: Click to item in Sort Dropdown");
        notebooksPage.selectItemProductSortDropDown("Price: High to Low");
        notebooksPage.sleepInSecond(2);
        log.info("Sort_04 - Step 02: Verify sort by price DESC ");
        Assert.assertTrue(notebooksPage.isProductSortByPriceDESC());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
