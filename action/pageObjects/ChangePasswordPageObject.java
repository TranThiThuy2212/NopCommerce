package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
    WebDriver driver;
    public ChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToOldPassword(String password) {
        waitForElementVisibile(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
    }

    public void inputToNewPassword(String newPassword) {
        waitForElementVisibile(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void inputToConfirmPassword(String newPassword) {
        waitForElementVisibile(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void clickToChangePasswordButton() {
        waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, ChangePasswordPageUI.LOGOUT_LINK);
        clickToElement(driver, ChangePasswordPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }
}
