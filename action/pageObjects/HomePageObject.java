package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }


    public boolean isMyAccountLinkIsDisplayed() {
        waitForElementVisibile(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public MyAccountPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }

    public SearchPageObject clickToSearchLinkAtFooter() {
        waitForElementClickable(driver, HomePageUI.SEARCH_LINK);
        clickToElement(driver, HomePageUI.SEARCH_LINK);
        return PageGeneratorManager.getSearchPage(driver);
    }

    public ComputersPageObject clickToComputerLink() {
        waitForElementClickable(driver, HomePageUI.COMPUTER_LINK);
        clickToElement(driver, HomePageUI.COMPUTER_LINK);
        return PageGeneratorManager.getComputerInfoPage(driver);
    }
}
