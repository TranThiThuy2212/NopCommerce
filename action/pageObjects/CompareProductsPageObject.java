package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CompareProductsPageUI;

public class CompareProductsPageObject extends BasePage {
    WebDriver driver;

    public CompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isNameProductdisplay(String productName) {
        waitForElementVisibile(driver, CompareProductsPageUI.PRODUCT_NAME,productName);
        return isElementDisplayed(driver, CompareProductsPageUI.PRODUCT_NAME, productName);
    }

    public void clickToClearListLink() {
        waitForElementClickable(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public boolean isCompareEmptydisplay(String compareEmptydisplay) {
        waitForElementVisibile(driver, CompareProductsPageUI.COMPARE_EMPTY,compareEmptydisplay);
        return isElementDisplayed(driver, CompareProductsPageUI.COMPARE_EMPTY, compareEmptydisplay);
    }

    public HomePageObject openHomePage(String homePageUrl) {
        openPageURL(driver, homePageUrl);
        return PageGeneratorManager.getHomePage(driver);
    }
}
