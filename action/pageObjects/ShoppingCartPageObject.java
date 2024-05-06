package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameJustAddedToCartDisplayed(String productName) {
        waitForElementVisibile(driver, ShoppingCartPageUI.NAME_PRODUCT_ADD_TO_CART,productName);
        return isElementDisplayed(driver, ShoppingCartPageUI.NAME_PRODUCT_ADD_TO_CART, productName);
    }

    public WishlistPageObject clickToWishlistLink() {
        waitForElementClickable(driver, ShoppingCartPageUI.WISHLIST_LINK);
        clickToElement(driver, ShoppingCartPageUI.WISHLIST_LINK);
        return PageGeneratorManager.getWishlistPage(driver);
    }

    public String getProductInfoInShoppingCart() {
        waitForElementVisibile(driver, ShoppingCartPageUI.PRODUCT_INFO);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_INFO);
    }
}
