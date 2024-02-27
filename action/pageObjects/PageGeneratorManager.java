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
    public static ProductPageObject getProductPage(WebDriver driver){
        return new ProductPageObject(driver);
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
    public static NotebooksPageObject getNotebooksPage(WebDriver driver){
        return new NotebooksPageObject(driver);
    }
    public static WishlistPageObject getWishlistPage(WebDriver driver){
        return new WishlistPageObject(driver);
    }
    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver){
        return new ShoppingCartPageObject(driver);
    }
    public static YourWishlistPageObject getYourWishlistPage(WebDriver driver){
        return new YourWishlistPageObject(driver);
    }
    public static CompareProductsPageObject getCompareProductsPage(WebDriver driver){
        return new CompareProductsPageObject(driver);
    }
    public static RecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver){
        return new RecentlyViewedProductsPageObject(driver);
    }

}
