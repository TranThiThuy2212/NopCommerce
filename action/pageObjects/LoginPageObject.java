package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisibile(driver, LoginPageUI.ERROR_MESSAGE_EMAIL);
        return getElementText(driver, LoginPageUI.ERROR_MESSAGE_EMAIL);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisibile(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisibile(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public String getErrorMessageAtLoginPage() {
        waitForElementVisibile(driver, LoginPageUI.ERROR_MESSAGE_AT_LOGIN_PAGE);
        return getElementText(driver, LoginPageUI.ERROR_MESSAGE_AT_LOGIN_PAGE);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
}
