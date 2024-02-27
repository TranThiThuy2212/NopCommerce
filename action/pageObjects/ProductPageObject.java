package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage {
    WebDriver driver;
    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WriteYourOwnReviewPageObject clickAddYourReview() {
        waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW);
        clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW);
        return new WriteYourOwnReviewPageObject(driver);
    }

    public void clickToAddToWishlistButton() {
        waitForElementClickable(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public String successMessageAddToWishlist() {
        waitForElementVisibile(driver, ProductPageUI.SUSSESS_MESSAGE_ADD_TO_WISHLIST);
        return getElementText(driver, ProductPageUI.SUSSESS_MESSAGE_ADD_TO_WISHLIST);
    }

    public void clickToIconClose() {
        waitForElementClickable(driver, ProductPageUI.ICON_CLOSE);
        clickToElement(driver, ProductPageUI.ICON_CLOSE);
    }

    public WishlistPageObject clickToWishlistLink() {
        waitForElementClickable(driver, ProductPageUI.WISHLISH_LINK);
        clickToElement(driver, ProductPageUI.WISHLISH_LINK);
        return PageGeneratorManager.getWishlistPage(driver);
    }


    public NotebooksPageObject clickBackToPage() {
        backToPage(driver);
        return PageGeneratorManager.getNotebooksPage(driver);
    }

    public RecentlyViewedProductsPageObject clickToRecentlyViewedProducts() {
        waitForElementClickable(driver, ProductPageUI.RECENTLY_VIEWED_PRODUCTS_LINK);
        clickToElement(driver, ProductPageUI.RECENTLY_VIEWED_PRODUCTS_LINK);
        return PageGeneratorManager.getRecentlyViewedProductsPage(driver);
    }
}
