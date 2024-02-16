package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.WriteYourOwnReviewPageUI;

public class WriteYourOwnReviewPageObject extends BasePage {
    WebDriver driver;
    public WriteYourOwnReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToReviewTitleTextbox(String title) {
        waitForElementVisibile(driver, WriteYourOwnReviewPageUI.REVIEW_TITLE_TEXTBOX);
        sendkeyToElement(driver, WriteYourOwnReviewPageUI.REVIEW_TITLE_TEXTBOX, title);
    }

    public void inputToReviewTextTextbox(String reviewText) {
        waitForElementVisibile(driver, WriteYourOwnReviewPageUI.REVIEW_TEXT_TEXTBOX);
        sendkeyToElement(driver, WriteYourOwnReviewPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, WriteYourOwnReviewPageUI.SUBMIT_RIVIEW_BUTTON);
        clickToElement(driver, WriteYourOwnReviewPageUI.SUBMIT_RIVIEW_BUTTON);
    }

    public MyAccountPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, WriteYourOwnReviewPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, WriteYourOwnReviewPageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
