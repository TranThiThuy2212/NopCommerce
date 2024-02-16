package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;
import pageUIs.MyAccountPageUI;

public class CustomerInfoPageObject extends BasePage {
    WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickChooseGender() {
        waitForElementClickable(driver, CustomerInfoPageUI.MALE_RADIO);
        checkToDefaultCheckboxRadio(driver,CustomerInfoPageUI.MALE_RADIO);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisibile(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisibile(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void selectDateOfBirthDay(String day) {
        waitForElementVisibile(driver, CustomerInfoPageUI.DAY_DRODOWN);
        selectItemInDefaultDropDown(driver, CustomerInfoPageUI.DAY_DRODOWN, day);
    }

    public void selectDateOfBirthMonth(String month) {
        waitForElementVisibile(driver, CustomerInfoPageUI.MONTH_DRODOWN);
        selectItemInDefaultDropDown(driver, CustomerInfoPageUI.MONTH_DRODOWN, month);
    }

    public void selectDateOfBirthYear(String year) {
        waitForElementVisibile(driver, CustomerInfoPageUI.YEAR_DRODOWN);
        selectItemInDefaultDropDown(driver, CustomerInfoPageUI.YEAR_DRODOWN, year);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisibile(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX,email);
    }

    public void inputToCompanyNameTextbox(String companyName) {
        waitForElementVisibile(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }

    public AddressPageObject clickToAddressLink() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LINK);
        clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);
        return PageGeneratorManager.getAddressPage(driver);
    }
}
