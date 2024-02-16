package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DesktopsPageUI;

public class DesktopsPageObject extends BasePage {
    WebDriver driver;
    public DesktopsPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public BuildYourOwnComputerPageObject clickToNameProduct() {
        waitForElementClickable(driver, DesktopsPageUI.PRODUCT_NAME);
        clickToElement(driver, DesktopsPageUI.PRODUCT_NAME);
        return PageGeneratorManager.getBuildYourOwnComputer(driver);
    }
}
