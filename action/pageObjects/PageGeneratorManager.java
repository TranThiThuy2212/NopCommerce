package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static MyAccountPageObject getMyAccountPage(WebDriver driver){
        return new MyAccountPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }
    public static AddressPageObject getAddressPage(WebDriver driver){
        return new AddressPageObject(driver);
    }
    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver){
        return new ChangePasswordPageObject(driver);
    }
    public static ComputersPageObject getComputerInfoPage(WebDriver driver){
        return new ComputersPageObject(driver);
    }
    public static DesktopsPageObject getDesktopInfoPage(WebDriver driver){
        return new DesktopsPageObject(driver);
    }
    public static BuildYourOwnComputerPageObject getBuildYourOwnComputer(WebDriver driver){
        return new BuildYourOwnComputerPageObject(driver);
    }
    public static WriteYourOwnReviewPageObject getWriteYourOwnReview(WebDriver driver){
        return new WriteYourOwnReviewPageObject(driver);
    }
    public static MyProductReviewPageObject getMyProductReview(WebDriver driver){
        return new MyProductReviewPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver){
        return new SearchPageObject(driver);
    }

}
