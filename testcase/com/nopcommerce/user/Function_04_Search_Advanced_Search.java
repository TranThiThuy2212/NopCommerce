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

        registerPage = homePage.clickToRegisterLink();
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(email);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(),"Your registration completed");
        homePage= registerPage.clickToContinueButton();
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        homePage=loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());

        searchPage=homePage.clickToSearchLinkAtFooter();
        Assert.assertTrue(searchPage.isSearchHeaderIsDisplayed());
    }
    @Test
    public void Search_01_Empty_Data(){
        searchPage.inputToSearchKeywordTextbox("");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getErrorMessageAtSearchPage(),"Search term minimum length is 3 characters");
    }
    @Test
    public void Search_02_Data_Not_Exit(){
        searchPage.inputToSearchKeywordTextbox("Macbook 2050");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNotFoundMessageAtSearchPage(),"No products were found that matched your criteria.");
    }
    @Test
    public void Search_03_Search_Relative(){
        searchPage.inputToSearchKeywordTextbox(SearchRelative);
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.numberOfProductDisplaySearchRelative(),2);
    }
    @Test
    public void Search_04_Search_Absolute(){
        searchPage.inputToSearchKeywordTextbox(SearchAbsolute);
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.numberOfProductDisplaySearchAbsolute(),1);
    }
    @Test
    public void Search_05_Parent_Categories(){
        searchPage.inputToSearchKeywordTextbox(Search);
        searchPage.clickToAdvanSearchCheckbox();
        searchPage.selectCategoryDrodown("Computers");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNotFoundMessageAtSearchPage(),"No products were found that matched your criteria.");
    }
    @Test
    public void Search_06_Sub_Categories(){
        searchPage.inputToSearchKeywordTextbox(Search);
        searchPage.clickToAdvanSearchCheckbox();
        searchPage.selectCategoryDrodown("Computers");
        searchPage.clickToSubCategoriesCheckbox();
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.numberOfProductDisplaySearch(),1);
    }
    @Test
    public void Search_07_Incorrect_Manufacturer(){
        searchPage.inputToSearchKeywordTextbox(Search);
        searchPage.clickToAdvanSearchCheckbox();
        searchPage.selectCategoryDrodown("Computers");
        searchPage.clickToSubCategoriesCheckbox();
        searchPage.selectManufacturerDrodown("HP");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNotFoundMessageAtSearchPage(),"No products were found that matched your criteria.");
    }
    @Test
    public void Search_08_Correct_Manufacturer(){
        searchPage.inputToSearchKeywordTextbox(Search);
        searchPage.clickToAdvanSearchCheckbox();
        searchPage.selectCategoryDrodown("Computers");
        searchPage.clickToSubCategoriesCheckbox();
        searchPage.selectManufacturerDrodown("Apple");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.numberOfProductDisplaySearch(),1);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
