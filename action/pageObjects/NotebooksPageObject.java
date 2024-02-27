package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.NotebooksPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotebooksPageObject extends BasePage {
    
    WebDriver driver;
    public NotebooksPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemProductSortDropDown(String valueItem) {
        waitForElementClickable(driver, NotebooksPageUI.SORT_BY_DROPDOWN);
        selectItemInDefaultDropDown(driver, NotebooksPageUI.SORT_BY_DROPDOWN, valueItem);
    }

    public boolean isProductSortByNameASC() {
        ArrayList<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText= getListWebElement(driver,NotebooksPageUI.SORT_AND_DISPLAY_BY_NAME);
        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }
        Collections.sort(productSortList);
        return productSortList.equals(productUIList);
    }

    public boolean isProductSortByNameDEC() {
        ArrayList<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText= getListWebElement(driver,NotebooksPageUI.SORT_AND_DISPLAY_BY_NAME);
        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }
        Collections.sort(productSortList);
        Collections.reverse(productSortList);
        return productSortList.equals(productUIList);
    }

    public boolean isProductSortByPriceASC() {
        ArrayList<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText= getListWebElement(driver,NotebooksPageUI.SORT_BY_PRICE);
        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }
        Collections.sort(productSortList);
        return productSortList.equals(productUIList);
    }

    public boolean isProductSortByPriceDESC() {
        ArrayList<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText= getListWebElement(driver,NotebooksPageUI.SORT_BY_PRICE);
        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }
        Collections.sort(productSortList);
        Collections.reverse(productSortList);
        return productSortList.equals(productUIList);
    }

    public void selectItemNumberProductDisplayDropDown(String valueItem) {
        waitForElementClickable(driver, NotebooksPageUI.DISPLAY_DROPDOWN);
        selectItemInDefaultDropDown(driver, NotebooksPageUI.DISPLAY_DROPDOWN, valueItem);
    }


    public void clickToPageTwo() {
        waitForElementVisibile(driver, NotebooksPageUI.PAGE_TWO);
        clickToElement(driver, NotebooksPageUI.PAGE_TWO);
    }

    public boolean isPageOneDisplay() {
        waitForElementVisibile(driver, NotebooksPageUI.PAGE_ONE);
        return isElementDisplayed(driver, NotebooksPageUI.PAGE_ONE);
    }

    public boolean isNextIconDisplay() {
        waitForElementVisibile(driver, NotebooksPageUI.NEXT_PAGE_ICON);
        return isElementDisplayed(driver, NotebooksPageUI.NEXT_PAGE_ICON);
    }

    public boolean isPreviousIconDisplay() {
        waitForElementVisibile(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
        return isElementDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
    }

    public int numberOfProductShow() {
        waitForElementVisibile(driver, NotebooksPageUI.SORT_AND_DISPLAY_BY_NAME);
        return getElementSize(driver, NotebooksPageUI.SORT_AND_DISPLAY_BY_NAME);
    }

    public boolean isPaggingUnDisplay() {
        return isElementUndisplayed(driver, NotebooksPageUI.PAGE_ONE);
    }

    public ProductPageObject clickToProductName(String nameProduct) {
        waitForElementClickable(driver, NotebooksPageUI.NAME_PRODUCT,nameProduct);
        clickToElement(driver, NotebooksPageUI.NAME_PRODUCT,nameProduct);
        return PageGeneratorManager.getProductPage(driver);
    }
}
