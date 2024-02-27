package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.WishlistPageUI;

public class WishlistPageObject extends BasePage {
    WebDriver driver;
    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameJustAddedDisplayed(String productName) {
        waitForElementVisibile(driver, WishlistPageUI.PRODUCT_NAME,productName);
        return isElementDisplayed(driver, WishlistPageUI.PRODUCT_NAME, productName);
    }

    public YourWishlistPageObject clickToYourWishlistURLForShareLink() {
        waitForElementClickable(driver, WishlistPageUI.YOUY_WISHLIST_URL_FOR_SHARE_LINK);
        clickToElement(driver, WishlistPageUI.YOUY_WISHLIST_URL_FOR_SHARE_LINK);
        return PageGeneratorManager.getYourWishlistPage(driver);
    }


    public void clickToAddToCartCheckbox() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
    }

    public ShoppingCartPageObject clickToAddToCartButton() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public boolean wishlist_Empty(String value) {
        waitForElementVisibile(driver, WishlistPageUI.WISHLIST_EMPTY,value);
        return isElementDisplayed(driver, WishlistPageUI.WISHLIST_EMPTY, value);
    }

    public HomePageObject openHomePage(String homePageUrl) {
        openPageURL(driver, homePageUrl);
        return PageGeneratorManager.getHomePage(driver);
    }

    public void clickRemoveIcon() {
        waitForElementClickable(driver, WishlistPageUI.REMOVE_ICON);
        clickToElement(driver, WishlistPageUI.REMOVE_ICON);
    }

    public boolean wishlist_Empty_Remove(String value) {
        waitForElementVisibile(driver, WishlistPageUI.WISHLIST_EMPTY_REMOVE,value);
        return isElementDisplayed(driver, WishlistPageUI.WISHLIST_EMPTY_REMOVE, value);
    }
}
