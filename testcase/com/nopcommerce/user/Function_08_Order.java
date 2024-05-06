package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Function_08_Order extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private ComputersPageObject computersPage;
    private DesktopsPageObject desktopsPage;
    private ProductPageObject productPage;
    private ShoppingCartPageObject shoppingCartPage;

    private String firstName, lastName, email,password, productName;
    private String Processor, RAM, HDD, OS, Software1, Software2, Software3;
    String wishlistUrl, homePageUrl;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName) {
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
        password="123456";
        productName ="Build your own computer";
        Processor="2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        RAM="8GB [+$60.00]";
        HDD="400 GB [+$100.00]";
        OS="Vista Premium [+$60.00]";
        Software1="Microsoft Office [+$50.00]";
        Software2="Acrobat Reader [+$10.00]";
        Software3="Total Commander [+$5.00]";

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
        homePageUrl = homePage.getPageUrl(driver);
        log.info("Pre-Condition - Step 14: Verify My Account link display");
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
        log.info("Pre-Condition - Step 15: Click to Computer link");
        computersPage=homePage.clickToComputerLink();
        log.info("Pre-Condition - Step 16: Click to Desktops link");
        desktopsPage=computersPage.clickToDesktopsLink();
        log.info("Pre-Condition - Step 17: Click to Name product");
        productPage = desktopsPage.clickToProductName(productName);
    }
    @Test
    public void Order_01_Add_Product_To_Cart(){
        log.info("Order_01 - Step 01: selected processor dropdown");
        productPage.selectProcessorDropDown(Processor);
        log.info("Order_01 - Step 02: selected Ram dropdown");
        productPage.selectRamDropDown(RAM);
        log.info("Order_01 - Step 03: check HDD radio");
        productPage.checkHDDRadio(HDD);
        log.info("Order_01 - Step 04: check OS radio");
        productPage.checkOSRadio(OS);
        log.info("Order_01 - Step 05: check Software checkbox");
        productPage.checkSoftwareCheckbox(Software1);
        productPage.checkSoftwareCheckbox(Software2);
        productPage.checkSoftwareCheckbox(Software3);
        log.info("Order_01 - Step 06: click to add to cart button");
        productPage.clickToAddToCartButton();
        log.info("Order_01 - Step 07: verify message product just added to cart");
        Assert.assertEquals(productPage.getSuccessMessageAddToCart(),"The product has been added to your shopping cart");
        productPage.clickToIconClose();
        productPage.sleepInSecond(2);
        log.info("Order_01 - Step 08: click to Shopping Cart link");
        shoppingCartPage = productPage.clickToShoppingCartLink();
        log.info("Order_01 - Step 09: verify product info just added to cart");
        Assert.assertEquals(shoppingCartPage.getProductInfoInShoppingCart(),"Processor:"+" "+Processor +"\nRAM:"+" "+RAM+"\nHDD:"+" "+HDD+"\nOS:"+" "+OS+"\nSoftware:"+" "+Software1+"\nSoftware:"+" "+Software2+"\nSoftware:"+" "+Software3);

    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
