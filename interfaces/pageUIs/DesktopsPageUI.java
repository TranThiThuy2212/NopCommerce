package pageUIs;

public class DesktopsPageUI {
    public static final String PRODUCT_NAME="xpath=//h2[@class='product-title']//a[text()='Build your own computer']";
    public static final String NAME_PRODUCT="xpath=//h2[@class='product-title']//a[text()='%s']";
    public static final String ADD_TO_COMPARE_BUTTON="xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']/div[@class='buttons']/button[text()='Add to compare list']";
    public static final String SUSSESS_MESSAGE_ADD_TO_WISHLIST="xpath=//div[@id='bar-notification']//p";
    public static final String ICON_CLOSE="xpath=//div[@id='bar-notification']//span[@class='close']";
    public static final String PRODUCT_COMPARISON_LINK="xpath=//div[@id='bar-notification']//p/a[text()='product comparison']";
}
