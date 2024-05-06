package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Function_07_Wishlist_Compare_Recent_View extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private ComputersPageObject computersPage;
    private DesktopsPageObject desktopsPage;
    private ProductPageObject productPage;
    private WishlistPageObject wishlistPage;
    private ShoppingCartPageObject shoppingCartPage;
    private YourWishlistPageObject yourWishlistPage;
    private CompareProductsPageObject compareProductsPage;
    private NotebooksPageObject notebooksPage;
    private RecentlyViewedProductsPageObject recentlyViewedProductsPage;

    private String firstName, lastName, email,password, productName;
    String wishlistUrl, homePageUrl;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName) {
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
        password="123456";
        productName ="Lenovo IdeaCentre 600 All-in-One PC";

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
        productPage = desktopsPage.clickToProductName("Lenovo IdeaCentre 600 All-in-One PC");
    }
    @Test
    public void Wishlist_01_Add_To_Wishlist(){
        log.info("Wishlist_01 - Step 01: Click to Add To Wishlist button");
        productPage.clickToAddToWishlistButton();
        log.info("Wishlist_01 - Step 02: Verify success message");
        Assert.assertEquals(productPage.successMessageAddToWishlist(),"The product has been added to your wishlist");
        log.info("Wishlist_01 - Step 03: Click to Close icon");
        productPage.clickToIconClose();
        productPage.sleepInSecond(2);
        log.info("Wishlist_01 - Step 04: Click to Wishlist link");
        wishlistPage = productPage.clickToWishlistLink();
        wishlistUrl = wishlistPage.getPageUrl(driver);
        log.info("Wishlist_01 - Step 05: Verify product name just added display");
        Assert.assertTrue(wishlistPage.isProductNameJustAddedDisplayed(productName));
        log.info("Wishlist_01 - Step 06: Click to Your Wishlist URL For Share link");
        yourWishlistPage = wishlistPage.clickToYourWishlistURLForShareLink();
        log.info("Wishlist_01 - Step 07: Verify header wishlist display");
        Assert.assertTrue(yourWishlistPage.isHeaderWishlistDisplayed("Wishlist of "+firstName+" "+lastName));
    }
    @Test
    public void Wishlist_02_Add_Product_To_Cart_From_Wishlist(){
        log.info("Wishlist_02 - Step 01: Navigate Wishlist page");
        wishlistPage = yourWishlistPage.openWishlistPage(wishlistUrl);
        log.info("Wishlist_02 - Step 02: Click to Add To Cart checkbox");
        wishlistPage.clickToAddToCartCheckbox();
        log.info("Wishlist_02 - Step 03: Click to Add To Cart button");
        shoppingCartPage= wishlistPage.clickToAddToCartButton();
        log.info("Wishlist_02 - Step 04: Verify Product just Added To Cart");
        Assert.assertTrue(shoppingCartPage.isProductNameJustAddedToCartDisplayed(productName));
        log.info("Wishlist_02 - Step 05: Click to Wishlist link");
        wishlistPage=shoppingCartPage.clickToWishlistLink();
        log.info("Wishlist_02 - Step 06: Verify The wishlist is empty");
        Assert.assertTrue(wishlistPage.wishlist_Empty("The wishlist is empty!"));
    }
    @Test
    public void Wishlist_03_Remove_Product_In_Wishlist_Page()
    {
        log.info("Wishlist_03 - Step 01: Navigate Home page");
        homePage = wishlistPage.openHomePage(homePageUrl);
        log.info("Wishlist_03 - Step 02: Click to Computer link");
        computersPage=homePage.clickToComputerLink();
        log.info("Wishlist_03 - Step 03: Click to Desktops link");
        desktopsPage=computersPage.clickToDesktopsLink();
        log.info("Wishlist_03 - Step 04: Click to Name product");
        productPage = desktopsPage.clickToProductName(productName);
        log.info("Wishlist_03 - Step 05: Click to Add To Wishlist button");
        productPage.clickToAddToWishlistButton();
        log.info("Wishlist_03 - Step 06: Verify success message");
        Assert.assertEquals(productPage.successMessageAddToWishlist(),"The product has been added to your wishlist");
        log.info("Wishlist_03 - Step 07: Click to Close icon");
        productPage.clickToIconClose();
        productPage.sleepInSecond(2);
        log.info("Wishlist_03 - Step 08: Click to Wishlist link");
        wishlistPage = productPage.clickToWishlistLink();
        log.info("Wishlist_03 - Step 09: Verify product name just added display");
        Assert.assertTrue(wishlistPage.isProductNameJustAddedDisplayed(productName));
        log.info("Wishlist_03 - Step 10: Click to Remove Icon");
        wishlistPage.clickRemoveIcon();
        log.info("Wishlist_03 - Step 11: Verify The wishlist is empty");
        Assert.assertTrue(wishlistPage.wishlist_Empty_Remove("The wishlist is empty!"));
    }
    @Test
    public void Wishlist_04_Add_Product_To_Compare(){
        log.info("Wishlist_04 - Step 01: Navigate Home page");
        homePage = wishlistPage.openHomePage(homePageUrl);
        log.info("Wishlist_04 - Step 02: Click to Computer link");
        computersPage=homePage.clickToComputerLink();
        log.info("Wishlist_04 - Step 03: Click to Desktops link");
        desktopsPage=computersPage.clickToDesktopsLink();
        log.info("Wishlist_04 - Step 04: Click to Add To Compare");
        desktopsPage.clickToAddToCompare(productName);
        log.info("Wishlist_04 - Step 05: Verify success message");
        Assert.assertEquals(desktopsPage.successMessageAddToWishlist(),"The product has been added to your product comparison");
        log.info("Wishlist_04 - Step 06: Click to Close icon");
        desktopsPage.clickToIconClose();
        log.info("Wishlist_04 - Step 07: Click to Add To Compare");
        desktopsPage.clickToAddToCompare("Build your own computer");
        log.info("Wishlist_04 - Step 08: Verify success message");
        Assert.assertEquals(desktopsPage.successMessageAddToWishlist(),"The product has been added to your product comparison");
        log.info("Wishlist_04 - Step 09: Click to product comparison link ");
        compareProductsPage = desktopsPage.clickToProductComparesonLink();
        log.info("Wishlist_04 - Step 10: Verify product name just added display");
        Assert.assertTrue(compareProductsPage.isNameProductdisplay(productName));
        Assert.assertTrue(compareProductsPage.isNameProductdisplay("Build your own computer"));
        log.info("Wishlist_04 - Step 11: Click to CLEAR LIST link");
        compareProductsPage.clickToClearListLink();
        log.info("Wishlist_04 - Step 12: Verify The Compare is empty");
        Assert.assertTrue(compareProductsPage.isCompareEmptydisplay("You have no items to compare."));
    }
    @Test
    public void Wishlist_05_Recently_Viewed_Products(){
        log.info("Wishlist_05 - Step 01: Navigate Home page");
        homePage = compareProductsPage.openHomePage(homePageUrl);
        log.info("Wishlist_05 - Step 02: Click to Computer link");
        computersPage=homePage.clickToComputerLink();
        log.info("Wishlist_05 - Step 03: Click to Notebooks link");
        notebooksPage =computersPage.clickToNotebooksLink();
        log.info("Wishlist_05 - Step 04: Click to Name product");
        productPage = notebooksPage.clickToProductName("Apple MacBook Pro 13-inch");
        log.info("Wishlist_05 - Step 05: Click to icon back to page");
        notebooksPage = productPage.clickBackToPage();
        log.info("Wishlist_05 - Step 06: Click to Name product");
        productPage = notebooksPage.clickToProductName("Asus N551JK-XO076H Laptop");
        log.info("Wishlist_05 - Step 07: Click to icon back to page");
        notebooksPage = productPage.clickBackToPage();
        log.info("Wishlist_05 - Step 08: Click to Name product");
        productPage = notebooksPage.clickToProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook");
        log.info("Wishlist_05 - Step 09: Click to icon back to page");
        notebooksPage = productPage.clickBackToPage();
        log.info("Wishlist_05 - Step 10: Click to Name product");
        productPage = notebooksPage.clickToProductName("HP Spectre XT Pro UltraBook");
        log.info("Wishlist_05 - Step 11: Click to icon back to page");
        notebooksPage = productPage.clickBackToPage();
        log.info("Wishlist_05 - Step 12: Click to Name product");
        productPage = notebooksPage.clickToProductName("Lenovo Thinkpad X1 Carbon Laptop");
        log.info("Wishlist_05 - Step 13: Click to Recently viewed products at footer");
        recentlyViewedProductsPage = productPage.clickToRecentlyViewedProducts();
        log.info("Wishlist_05 - Step 14: Verify product name just added display");
        Assert.assertTrue(recentlyViewedProductsPage.isNameProductdisplay("Lenovo Thinkpad X1 Carbon Laptop"));
        Assert.assertTrue(recentlyViewedProductsPage.isNameProductdisplay("HP Spectre XT Pro UltraBook"));
        Assert.assertTrue(recentlyViewedProductsPage.isNameProductdisplay("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
    }


    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
