package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.SearchPageUI;

import static java.lang.String.valueOf;

public class SearchPageObject extends BasePage {
    WebDriver driver;
    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchHeaderIsDisplayed() {
        waitForElementVisibile(driver, SearchPageUI.SEARCH_HEADER);
        return isElementDisplayed(driver, SearchPageUI.SEARCH_HEADER);
    }

    public void inputToSearchKeywordTextbox(String value) {
        waitForElementVisibile(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, value);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public String getErrorMessageAtSearchPage() {
        waitForElementVisibile(driver, SearchPageUI.MESSAGE_SEARCH_RESULT);
        return getElementText(driver, SearchPageUI.MESSAGE_SEARCH_RESULT);
    }

    public String getNotFoundMessageAtSearchPage() {
        waitForElementVisibile(driver, SearchPageUI.NOT_FOUND_MESSAGE);
        return getElementText(driver, SearchPageUI.NOT_FOUND_MESSAGE);
    }


    public int numberOfProductDisplaySearchRelative() {
        waitForElementVisibile(driver, SearchPageUI.SEARCH_RELAVITE_RESULT);
        return getElementSize(driver, SearchPageUI.SEARCH_RELAVITE_RESULT);
    }

    public int numberOfProductDisplaySearchAbsolute() {
        waitForElementVisibile(driver, SearchPageUI.SEARCH_ABSOLUTE_RESULT);
        return getElementSize(driver, SearchPageUI.SEARCH_ABSOLUTE_RESULT);
    }

    public void clickToAdvanSearchCheckbox() {
        waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectCategoryDrodown(String valueCategory) {
        waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropDown(driver, SearchPageUI.CATEGORY_DROPDOWN, valueCategory);
    }

    public void clickToSubCategoriesCheckbox() {
        waitForElementClickable(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
        checkToDefaultCheckboxRadio(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
    }

    public int numberOfProductDisplaySearch() {
        waitForElementVisibile(driver, SearchPageUI.SEARCH_RESULT);
        return getElementSize(driver, SearchPageUI.SEARCH_RESULT);
    }

    public void selectManufacturerDrodown(String valueManufacturer) {
        waitForElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropDown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, valueManufacturer);
    }
}
