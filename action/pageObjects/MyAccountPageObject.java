package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;
    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public CustomerInfoPageObject clickToCustomerInfoLink() {
        waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }

    public String getSuccessMessageAtCustomerInfoPage() {
        waitForElementVisibile(driver, MyAccountPageUI.SUCCESS_MESSAGE_CUSTOMER_INFO);
        return getElementText(driver, MyAccountPageUI.SUCCESS_MESSAGE_CUSTOMER_INFO);
    }

    public AddressPageObject clickToAddressLink() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LINK);
        clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public String getSuccessMessageAtAddressPage() {
        waitForElementVisibile(driver, MyAccountPageUI.SUCCESS_MESSAGE_ADDRESS);
        return getElementText(driver, MyAccountPageUI.SUCCESS_MESSAGE_ADDRESS);
    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, MyAccountPageUI.ICON_CLOSE_MESSAGE);
        clickToElement(driver, MyAccountPageUI.ICON_CLOSE_MESSAGE);
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
        clickToElement(driver, MyAccountPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public ComputersPageObject clickToComputerLink() {
        waitForElementClickable(driver, MyAccountPageUI.COMPUTER_LINK);
        clickToElement(driver, MyAccountPageUI.COMPUTER_LINK);
        return PageGeneratorManager.getComputerInfoPage(driver);
    }

    public String getSuccessMessageAtProductReview() {
        waitForElementVisibile(driver, MyAccountPageUI.SUCCESS_MESSAGE_MY_PRODUCT_REVIEW);
        return getElementText(driver, MyAccountPageUI.SUCCESS_MESSAGE_MY_PRODUCT_REVIEW);
    }

    public MyProductReviewPageObject clickToMyProductReview() {
        waitForElementClickable(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
        clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
        return PageGeneratorManager.getMyProductReview(driver);
    }
}
