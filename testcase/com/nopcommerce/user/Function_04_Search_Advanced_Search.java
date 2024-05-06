package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Function_04_Search_Advanced_Search extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private SearchPageObject searchPage;

    private String firstName, lastName, email,password, SearchRelative, SearchAbsolute,Search;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName){
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
        password="123456";
        SearchRelative="Lenovo";
        SearchAbsolute="Lenovo Thinkpad X1";
        Search="Apple MacBook Pro";
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
        log.info("Pre-Condition - Step 15: Click to Search link at Footer");
        searchPage=homePage.clickToSearchLinkAtFooter();
        log.info("Pre-Condition - Step 16: Verify Search header display");
        Assert.assertTrue(searchPage.isSearchHeaderIsDisplayed());
    }
    @Test
    public void Search_01_Empty_Data(){
        log.info("Search_01 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox("");
        log.info("Search_01 - Step 02: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_01 - Step 03: Verify Error message displayed");
        Assert.assertEquals(searchPage.getErrorMessageAtSearchPage(),"Search term minimum length is 3 characters");
    }
    @Test
    public void Search_02_Data_Not_Exit(){
        log.info("Search_02 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox("Macbook 2050");
        log.info("Search_02 - Step 02: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_02 - Step 03: Verify Not Found message displayed");
        Assert.assertEquals(searchPage.getNotFoundMessageAtSearchPage(),"No products were found that matched your criteria.");
    }
    @Test
    public void Search_03_Search_Relative(){
        log.info("Search_03 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox(SearchRelative);
        log.info("Search_03 - Step 02: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_03 - Step 03: Verify number of product displayed");
        Assert.assertEquals(searchPage.numberOfProductDisplaySearchRelative(),2);
    }
    @Test
    public void Search_04_Search_Absolute(){
        log.info("Search_04 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox(SearchAbsolute);
        log.info("Search_04 - Step 02: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_04 - Step 03: Verify number of product displayed");
        Assert.assertEquals(searchPage.numberOfProductDisplaySearchAbsolute(),1);
    }
    @Test
    public void Search_05_Parent_Categories(){
        log.info("Search_05 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox(Search);
        log.info("Search_05 - Step 02: Click to Advanced Search textbox");
        searchPage.clickToAdvanSearchCheckbox();
        log.info("Search_05 - Step 03: Select Category dropdown");
        searchPage.selectCategoryDrodown("Computers");
        log.info("Search_05 - Step 04: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_05 - Step 05: Verify Not Found message displayed");
        Assert.assertEquals(searchPage.getNotFoundMessageAtSearchPage(),"No products were found that matched your criteria.");
    }
    @Test
    public void Search_06_Sub_Categories(){
        log.info("Search_06 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox(Search);
        log.info("Search_06 - Step 02: Click to Advanced Search textbox");
        searchPage.clickToAdvanSearchCheckbox();
        log.info("Search_06 - Step 03: Select Category dropdown");
        searchPage.selectCategoryDrodown("Computers");
        log.info("Search_06 - Step 04: Click to Sub Category textbox");
        searchPage.clickToSubCategoriesCheckbox();
        log.info("Search_06 - Step 05: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_06 - Step 06: Verify number of product displayed");
        Assert.assertEquals(searchPage.numberOfProductDisplaySearch(),1);
    }
    @Test
    public void Search_07_Incorrect_Manufacturer(){
        log.info("Search_07 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox(Search);
        log.info("Search_07 - Step 02: Click to Advanced Search textbox");
        searchPage.clickToAdvanSearchCheckbox();
        log.info("Search_07 - Step 03: Select Category dropdown");
        searchPage.selectCategoryDrodown("Computers");
        log.info("Search_07 - Step 04: Click to Sub Category textbox");
        searchPage.clickToSubCategoriesCheckbox();
        log.info("Search_07 - Step 05: Select Manufacturer dropdown");
        searchPage.selectManufacturerDrodown("HP");
        log.info("Search_07 - Step 06: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_07 - Step 07: Verify Not Found message displayed");
        Assert.assertEquals(searchPage.getNotFoundMessageAtSearchPage(),"No products were found that matched your criteria.");
    }
    @Test
    public void Search_08_Correct_Manufacturer(){
        log.info("Search_08 - Step 01: Input to Search textbox");
        searchPage.inputToSearchKeywordTextbox(Search);
        log.info("Search_08 - Step 02: Click to Advanced Search textbox");
        searchPage.clickToAdvanSearchCheckbox();
        log.info("Search_08 - Step 03: Select Category dropdown");
        searchPage.selectCategoryDrodown("Computers");
        log.info("Search_08 - Step 04: Click to Sub Category textbox");
        searchPage.clickToSubCategoriesCheckbox();
        log.info("Search_08 - Step 05: Select Manufacturer dropdown");
        searchPage.selectManufacturerDrodown("Apple");
        log.info("Search_08 - Step 06: Click to Search button");
        searchPage.clickToSearchButton();
        log.info("Search_08 - Step 07: Verify number of product displayed");
        Assert.assertEquals(searchPage.numberOfProductDisplaySearch(),1);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
