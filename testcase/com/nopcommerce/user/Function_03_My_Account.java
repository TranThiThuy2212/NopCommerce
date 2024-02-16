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
    private BuildYourOwnComputerPageObject buildYourOwnComputerPage;
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
        myAccountPage=homePage.clickToMyAccountLink();
    }

    @Test
    public void My_Account_01_Customer_Info(){
        customerInfoPage=myAccountPage.clickToCustomerInfoLink();
        customerInfoPage.clickChooseGender();
        customerInfoPage.inputToFirstNameTextbox(FirstName);
        customerInfoPage.inputToLastNameTextbox(LastName);
        customerInfoPage.selectDateOfBirthDay(day);
        customerInfoPage.selectDateOfBirthMonth(month);
        customerInfoPage.selectDateOfBirthYear(year);
        customerInfoPage.inputToEmailTextbox(Email);
        customerInfoPage.inputToCompanyNameTextbox(CompanyName);
        customerInfoPage.clickToSaveButton();
        Assert.assertEquals(myAccountPage.getSuccessMessageAtCustomerInfoPage(),"The customer info has been updated successfully.");
        myAccountPage.clickToCloseIcon();
    }
    @Test
    public void My_Account_02_Address(){
        customerInfoPage.openPagesAtMyAccountByPageName(driver,"Addresses");
        addressPage =PageGeneratorManager.getAddressPage(driver);
        addressPage.clickAddNewButton();
        addressPage.inputToFirstNameTextbox(FirstName);
        addressPage.inputToLastNameTextbox(LastName);
        addressPage.inputToEmailTextbox(Email);
        addressPage.selectCountry(Country);
        addressPage.inputToCityTextbox(City);
        addressPage.inputToAddress1Textbox(Address);
        addressPage.inputToZipTextbox(ZipCode);
        addressPage.inputToPhoneNumberTextbox(PhoneNumber);
        addressPage.clickSaveButton();
        Assert.assertEquals(myAccountPage.getSuccessMessageAtAddressPage(),"The new address has been added successfully.");
        myAccountPage.clickToCloseIcon();

    }
    @Test
    public void My_Account_03_Change_Password(){
        addressPage.openPagesAtMyAccountByPageName(driver,"Change password");
        changePasswordPage =PageGeneratorManager.getChangePasswordPage(driver);
        changePasswordPage.inputToOldPassword(password);
        changePasswordPage.inputToNewPassword(newPassword);
        changePasswordPage.inputToConfirmPassword(newPassword);
        changePasswordPage.clickToChangePasswordButton();
        Assert.assertEquals(myAccountPage.getSuccessMessageAtAddressPage(),"Password was changed");
        myAccountPage.clickToCloseIcon();
        myAccountPage.sleepInSecond(2);
        homePage= myAccountPage.clickToLogoutLink();
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(Email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtLoginPage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(Email);
        loginPage.inputToPasswordTextbox(newPassword);
        homePage=loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
        myAccountPage=homePage.clickToMyAccountLink();
    }
    @Test
    public void My_Account_04_My_Product_Reviews(){
        computersPage=myAccountPage.clickToComputerLink();
        desktopsPage=computersPage.clickToDesktopsLink();
        buildYourOwnComputerPage = desktopsPage.clickToNameProduct();
        writeYourOwnReviewPage=buildYourOwnComputerPage.clickAddYourReview();
        writeYourOwnReviewPage.inputToReviewTitleTextbox("ABCDE");
        writeYourOwnReviewPage.inputToReviewTextTextbox("HANG RAT TOT");
        writeYourOwnReviewPage.clickToSubmitReviewButton();
        Assert.assertEquals(myAccountPage.getSuccessMessageAtProductReview(),"Product review is successfully added.");
        myAccountPage = writeYourOwnReviewPage.clickToMyAccountLink();
        //myProductReviewPage = myAccountPage.clickToMyProductReview();
        customerInfoPage.openPagesAtMyAccountByPageName(driver,"My product reviews");
        myProductReviewPage =PageGeneratorManager.getMyProductReview(driver);
        Assert.assertEquals(myProductReviewPage.getReviewTextAtProductReview(),"HANG RAT TOT");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
