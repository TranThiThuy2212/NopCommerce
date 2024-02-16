package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyProductReviewUI;

public class MyProductReviewPageObject extends BasePage {
    WebDriver driver;
    public MyProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getReviewTextAtProductReview() {
        waitForElementVisibile(driver, MyProductReviewUI.REVIEW_TEXT);
        return getElementText(driver, MyProductReviewUI.REVIEW_TEXT);
    }
}
