package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DesktopsPageUI;

public class DesktopsPageObject extends BasePage {
    WebDriver driver;
    public DesktopsPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public ProductPageObject clickToNameProduct() {
        waitForElementClickable(driver, DesktopsPageUI.PRODUCT_NAME);
        clickToElement(driver, DesktopsPageUI.PRODUCT_NAME);
        return PageGeneratorManager.getProductPage(driver);
    }

    public ProductPageObject clickToProductName(String productName) {
        waitForElementClickable(driver, DesktopsPageUI.NAME_PRODUCT,productName);
        clickToElement(driver, DesktopsPageUI.NAME_PRODUCT,productName);
        return PageGeneratorManager.getProductPage(driver);
    }

    public void clickToAddToCompare(String productName) {
        waitForElementClickable(driver, DesktopsPageUI.ADD_TO_COMPARE_BUTTON,productName);
        clickToElement(driver, DesktopsPageUI.ADD_TO_COMPARE_BUTTON,productName);
    }

    public String successMessageAddToWishlist() {
        waitForElementVisibile(driver, DesktopsPageUI.SUSSESS_MESSAGE_ADD_TO_WISHLIST);
        return getElementText(driver, DesktopsPageUI.SUSSESS_MESSAGE_ADD_TO_WISHLIST);
    }

    public void clickToIconClose() {
        waitForElementClickable(driver, DesktopsPageUI.ICON_CLOSE);
        clickToElement(driver, DesktopsPageUI.ICON_CLOSE);
    }

    public CompareProductsPageObject clickToProductComparesonLink() {
        waitForElementClickable(driver, DesktopsPageUI.PRODUCT_COMPARISON_LINK);
        clickToElement(driver, DesktopsPageUI.PRODUCT_COMPARISON_LINK);
        return PageGeneratorManager.getCompareProductsPage(driver);
    }
}
