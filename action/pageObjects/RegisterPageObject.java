package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;
    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getErrorMessageAtFirstNameTextbox() {
        waitForElementVisibile(driver, RegisterPageUI.ERROR_MESSAGE_FIRST_NAME);
        return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_FIRST_NAME);
    }

    public String getErrorMessageAtLastNameTextbox() {
        waitForElementVisibile(driver, RegisterPageUI.ERROR_MESSAGE_LAST_NAME);
        return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_LAST_NAME);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisibile(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL);
        return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisibile(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD);
        return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD);
    }

    public String getErrorMessageAtConfirmPasswordTextbox() {
        waitForElementVisibile(driver, RegisterPageUI.ERROR_MESSAGE_CONFTRM_PASSWORD);
        return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_CONFTRM_PASSWORD);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisibile(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisibile(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisibile(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisibile(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void inputToConfirmPasswordTextbox(String password) {
        waitForElementVisibile(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public String getSuccessMessageAtRegisterPage() {
        waitForElementVisibile(driver, RegisterPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.SUCCESS_MESSAGE);
    }

    public String getErrorMessageAtRegisterPage() {
        waitForElementVisibile(driver, RegisterPageUI.ERROR_MESSAGE_EXITING_EMAIL);
        return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_EXITING_EMAIL);
    }

    public HomePageObject clickToContinueButton() {
        waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
}
