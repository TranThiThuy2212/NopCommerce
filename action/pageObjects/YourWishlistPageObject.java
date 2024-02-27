package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.YourWishlistPageUI;

public class YourWishlistPageObject extends BasePage {
    WebDriver driver;
    public YourWishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isHeaderWishlistDisplayed(String header) {
        waitForElementVisibile(driver, YourWishlistPageUI.HEADER_YOUR_WISHLIST,header);
        return isElementDisplayed(driver, YourWishlistPageUI.HEADER_YOUR_WISHLIST, header);
    }

    public WishlistPageObject openWishlistPage(String wishlistUrl) {
        openPageURL(driver, wishlistUrl);
        return PageGeneratorManager.getWishlistPage(driver);
    }
}
