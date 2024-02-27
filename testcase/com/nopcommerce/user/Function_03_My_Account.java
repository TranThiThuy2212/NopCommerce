package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Function_03_My_Account extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private MyAccountPageObject myAccountPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private ChangePasswordPageObject changePasswordPage;
    private ComputersPageObject computersPage;
    private DesktopsPageObject desktopsPage;
    private ProductPageObject productPage;
    private WriteYourOwnReviewPageObject writeYourOwnReviewPage;
    private MyProductReviewPageObject myProductReviewPage;

    private String firstName, lastName, email,password;
    private String FirstName, LastName, Email,CompanyName,day,month,year;
    private String Country, City, Address,ZipCode,PhoneNumber, newPassword;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName){
        driver = getBrowserDriver(browerName);
        firstName="Tran";
        lastName="Thuy";
        email="thuy"+ganarateNumber()+"@gmail.com";
        password="123456";
        newPassword="999999";

        FirstName="Dau";
        LastName="Thi";
        Email="thuy1234"+ganarateNumber()+"@gmail.com";
        CompanyName="Company ABC";
        day="10";
        month="May";
        year="2002";

        Country="Viet Nam";
        City="Hanoi";
        Address="123 Street";
        ZipCode="12345";
        PhoneNumber="0972333456";

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
        log.info("Pre-Condition - Step 15: Click to My Account link");
        myAccountPage=homePage.clickToMyAccountLink();
    }

    @Test
    public void My_Account_01_Customer_Info(){
        log.info("My_Account_01 - Step 01: Click to Customer Info link");
        customerInfoPage=myAccountPage.clickToCustomerInfoLink();
        log.info("My_Account_01 - Step 02: Select Gender radio");
        customerInfoPage.clickChooseGender();
        log.info("My_Account_01 - Step 03: Input to First Name textbox");
        customerInfoPage.inputToFirstNameTextbox(FirstName);
        log.info("My_Account_01 - Step 04: Input to Last Name textbox");
        customerInfoPage.inputToLastNameTextbox(LastName);
        log.info("My_Account_01 - Step 05: Select Date of Birth Day dropdown");
        customerInfoPage.selectDateOfBirthDay(day);
        log.info("My_Account_01 - Step 06: Select Date of Birth Month dropdown");
        customerInfoPage.selectDateOfBirthMonth(month);
        log.info("My_Account_01 - Step 07: Select Date of Birth Year dropdown");
        customerInfoPage.selectDateOfBirthYear(year);
        log.info("My_Account_01 - Step 08: Input to Email textbox");
        customerInfoPage.inputToEmailTextbox(Email);
        log.info("My_Account_01 - Step 09: Input to Company textbox");
        customerInfoPage.inputToCompanyNameTextbox(CompanyName);
        log.info("My_Account_01 - Step 10: Click to Save button");
        customerInfoPage.clickToSaveButton();
        log.info("My_Account_01 - Step 11: Verify success message at Customer Info page");
        Assert.assertEquals(myAccountPage.getSuccessMessageAtCustomerInfoPage(),"The customer info has been updated successfully.");
        log.info("My_Account_01 - Step 12: Click to Close Icon");
        myAccountPage.clickToCloseIcon();
    }
    @Test
    public void My_Account_02_Address(){
        log.info("My_Account_02 - Step 01: Click to Address link");
        customerInfoPage.openPagesAtMyAccountByPageName(driver,"Addresses");
        addressPage =PageGeneratorManager.getAddressPage(driver);
        log.info("My_Account_02 - Step 02: Click to Add New button");
        addressPage.clickAddNewButton();
        log.info("My_Account_02 - Step 03: Input to First Name textbox");
        addressPage.inputToFirstNameTextbox(FirstName);
        log.info("My_Account_02 - Step 04: Input to Last Name textbox");
        addressPage.inputToLastNameTextbox(LastName);
        log.info("My_Account_02 - Step 05: Input to Email textbox");
        addressPage.inputToEmailTextbox(Email);
        log.info("My_Account_02 - Step 06: Input to Country textbox");
        addressPage.selectCountry(Country);
        log.info("My_Account_02 - Step 07: Input to City textbox");
        addressPage.inputToCityTextbox(City);
        log.info("My_Account_02 - Step 08: Input to Address textbox");
        addressPage.inputToAddress1Textbox(Address);
        log.info("My_Account_02 - Step 09: Input to Zip code textbox");
        addressPage.inputToZipTextbox(ZipCode);
        log.info("My_Account_02 - Step 10: Input to Phone Number textbox");
        addressPage.inputToPhoneNumberTextbox(PhoneNumber);
        log.info("My_Account_02 - Step 11: Click to Save button");
        addressPage.clickSaveButton();
        log.info("My_Account_02 - Step 12: Verify success message at Address page");
        Assert.assertEquals(myAccountPage.getSuccessMessageAtAddressPage(),"The new address has been added successfully.");
        log.info("My_Account_02 - Step 13: Click to Close Icon");
        myAccountPage.clickToCloseIcon();

    }
    @Test
    public void My_Account_03_Change_Password(){
        log.info("My_Account_03 - Step 01: Click to Change password link");
        addressPage.openPagesAtMyAccountByPageName(driver,"Change password");
        changePasswordPage =PageGeneratorManager.getChangePasswordPage(driver);
        log.info("My_Account_03 - Step 02: Input to Old Password textbox");
        changePasswordPage.inputToOldPassword(password);
        log.info("My_Account_03 - Step 03: Input to New Password textbox");
        changePasswordPage.inputToNewPassword(newPassword);
        log.info("My_Account_03 - Step 04: Input to Confirm Password textbox");
        changePasswordPage.inputToConfirmPassword(newPassword);
        log.info("My_Account_03 - Step 05: Click to Change Password button");
        changePasswordPage.clickToChangePasswordButton();
        log.info("My_Account_03 - Step 06: Verify success message at Change password page");
        Assert.assertEquals(myAccountPage.getSuccessMessageAtAddressPage(),"Password was changed");
        log.info("My_Account_03 - Step 07: Click to Close Icon");
        myAccountPage.clickToCloseIcon();
        myAccountPage.sleepInSecond(2);
        log.info("My_Account_03 - Step 08: Click to Logout link");
        homePage= myAccountPage.clickToLogoutLink();
        log.info("My_Account_03 - Step 09: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("My_Account_03 - Step 11: input to Email textbox");
        loginPage.inputToEmailTextbox(Email);
        log.info("My_Account_03 - Step 12: input to Password textbox");
        loginPage.inputToPasswordTextbox(password);
        log.info("My_Account_03 - Step 13: Click to Login button");
        loginPage.clickToLoginButton();
        log.info("My_Account_03 - Step 14: Verify error message at Login page");
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        log.info("My_Account_03 - Step 15: Click to Login link");
        loginPage = homePage.clickToLoginLink();
        log.info("My_Account_03 - Step 16: input to Email textbox");
        loginPage.inputToEmailTextbox(Email);
        log.info("My_Account_03 - Step 17: input to Password textbox");
        loginPage.inputToPasswordTextbox(newPassword);
        log.info("My_Account_03 - Step 18: Click to Login button");
        homePage=loginPage.clickToLoginButton();
        log.info("My_Account_03 - Step 19: Verify My Account link display");
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
        log.info("My_Account_03 - Step 20: Click to My Account link");
        myAccountPage=homePage.clickToMyAccountLink();
    }
    @Test
    public void My_Account_04_My_Product_Reviews(){
        log.info("My_Account_04 - Step 01: Click to Computers link");
        computersPage=myAccountPage.clickToComputerLink();
        log.info("My_Account_04 - Step 02: Click to Desktops link");
        desktopsPage=computersPage.clickToDesktopsLink();
        log.info("My_Account_04 - Step 03: Click to Name product");
        productPage = desktopsPage.clickToNameProduct();
        log.info("My_Account_04 - Step 04: Click to Add Your Review");
        writeYourOwnReviewPage= productPage.clickAddYourReview();
        log.info("My_Account_04 - Step 05: Input to Review Title Textbox");
        writeYourOwnReviewPage.inputToReviewTitleTextbox("ABCDE");
        log.info("My_Account_04 - Step 06: Input to Review Text Textbox");
        writeYourOwnReviewPage.inputToReviewTextTextbox("HANG RAT TOT");
        log.info("My_Account_04 - Step 07: Click to Submit Review button");
        writeYourOwnReviewPage.clickToSubmitReviewButton();
        log.info("My_Account_04 - Step 08: Verify success message at Product review page");
        Assert.assertEquals(myAccountPage.getSuccessMessageAtProductReview(),"Product review is successfully added.");
        log.info("My_Account_04 - Step 09: Click to My Account link");
        myAccountPage = writeYourOwnReviewPage.clickToMyAccountLink();
        log.info("My_Account_04 - Step 10: Click to My product reviews link");
        customerInfoPage.openPagesAtMyAccountByPageName(driver,"My product reviews");
        myProductReviewPage =PageGeneratorManager.getMyProductReview(driver);
        log.info("My_Account_04 - Step 11: Verify Review Text at My product reviews");
        Assert.assertEquals(myProductReviewPage.getReviewTextAtProductReview(),"HANG RAT TOT");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
