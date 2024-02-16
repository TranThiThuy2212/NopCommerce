package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class AddressPageObject extends BasePage {
    WebDriver driver;
    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewButton() {
        waitForElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisibile(driver, AddressPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisibile(driver, AddressPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisibile(driver, AddressPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX,email);
    }

    public void selectCountry(String country) {
        waitForElementVisibile(driver, AddressPageUI.COUNTRY_DRODOWN);
        selectItemInDefaultDropDown(driver, AddressPageUI.COUNTRY_DRODOWN, country);
    }

    public void inputToCityTextbox(String city) {
        waitForElementVisibile(driver, AddressPageUI.CITY_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.CITY_TEXTBOX,city);
    }

    public void inputToAddress1Textbox(String address) {
        waitForElementVisibile(driver, AddressPageUI.ADDRESS_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.ADDRESS_TEXTBOX,address);
    }

    public void inputToZipTextbox(String zipCode) {
        waitForElementVisibile(driver, AddressPageUI.ZIP_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.ZIP_TEXTBOX,zipCode);
    }

    public void inputToPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisibile(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX,phoneNumber);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, AddressPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressPageUI.SAVE_BUTTON);
    }
}
