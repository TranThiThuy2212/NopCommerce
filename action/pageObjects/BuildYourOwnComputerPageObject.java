package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BuildYourOwnComputerPageUI;

public class BuildYourOwnComputerPageObject extends BasePage {
    WebDriver driver;
    public BuildYourOwnComputerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WriteYourOwnReviewPageObject clickAddYourReview() {
        waitForElementClickable(driver, BuildYourOwnComputerPageUI.ADD_YOUR_REVIEW);
        clickToElement(driver, BuildYourOwnComputerPageUI.ADD_YOUR_REVIEW);
        return new WriteYourOwnReviewPageObject(driver);
    }
}
