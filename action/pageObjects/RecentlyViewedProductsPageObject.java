package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPageObject extends BasePage {
    WebDriver driver;
    public RecentlyViewedProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNameProductdisplay(String ProductName) {
        waitForElementVisibile(driver, RecentlyViewedProductsPageUI.PRODUCT_NAME, ProductName);
        return isElementDisplayed(driver, RecentlyViewedProductsPageUI.PRODUCT_NAME, ProductName);
    }
}
