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

    public void selectProcessorDropDown(String processor) {
        waitForElementClickable(driver, ProductPageUI.PROCESSOR_DROPDOWN, processor);
        selectItemInDefaultDropDown(driver, ProductPageUI.PROCESSOR_DROPDOWN, processor);
    }

    public void selectRamDropDown(String ram) {
        waitForElementClickable(driver, ProductPageUI.RAM_DROPDOWN, ram);
        selectItemInDefaultDropDown(driver, ProductPageUI.RAM_DROPDOWN, ram);
    }

    public void checkHDDRadio(String hdd) {
        waitForElementClickable(driver, ProductPageUI.HDD_RADIO, hdd);
        checkToDefaultCheckboxRadio(driver, ProductPageUI.HDD_RADIO, hdd);
    }

    public void checkOSRadio(String os) {
        waitForElementClickable(driver, ProductPageUI.OS_RADIO, os);
        checkToDefaultCheckboxRadio(driver, ProductPageUI.OS_RADIO, os);
    }

    public void checkSoftwareCheckbox(String software) {
        waitForElementClickable(driver, ProductPageUI.SOFTWARE_CHECKBOX, software);
        checkToDefaultCheckboxRadio(driver, ProductPageUI.SOFTWARE_CHECKBOX, software);
    }

    public void clickToAddToCartButton() {
        waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
    }

    public String getSuccessMessageAddToCart() {
        waitForElementVisibile(driver, ProductPageUI.MESSAGE_SUCCESS_ADD_TO_CART);
        return getElementText(driver, ProductPageUI.MESSAGE_SUCCESS_ADD_TO_CART);
    }

    public ShoppingCartPageObject clickToShoppingCartLink() {
        waitForElementClickable(driver, ProductPageUI.SHOPPING_CART_LINK);
        clickToElement(driver, ProductPageUI.SHOPPING_CART_LINK);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }
}
