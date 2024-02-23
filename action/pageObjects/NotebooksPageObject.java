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
        List<WebElement> productNameText= getListWebElement(driver,NotebooksPageUI.SORT_BY_NAME);
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
        List<WebElement> productNameText= getListWebElement(driver,NotebooksPageUI.SORT_BY_NAME);
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
}
