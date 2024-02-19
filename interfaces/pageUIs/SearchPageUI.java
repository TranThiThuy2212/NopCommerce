package pageUIs;

public class SearchPageUI {
    public static final String SEARCH_HEADER="xpath=//div[@class='page search-page']//h1[text()='Search']";
    public static final String SEARCH_KEYWORD_TEXTBOX="xpath=//input[@class='search-text']";
    public static final String SEARCH_BUTTON="xpath=//div[@class='search-input']//button[text()='Search']";
    public static final String NOT_FOUND_MESSAGE="xpath=//div[@class='search-results']//div[@class='no-result']";
    public static final String MESSAGE_SEARCH_RESULT="xpath=//div[@class='search-results']//div[@class='warning']";
    public static final String SEARCH_RELAVITE_RESULT="xpath=//div[@class='search-results']//div[@class='details']//a[contains(text(),'Lenovo')]";
    public static final String SEARCH_ABSOLUTE_RESULT="xpath=//div[@class='search-results']//div[@class='details']//a[contains(text(),'Lenovo Thinkpad X1')]";
    public static final String CATEGORY_DROPDOWN="xpath=//label[text()='Category:']/following-sibling::select[@id='cid']";
    public static final String MANUFACTURER_DROPDOWN="xpath=//label[text()='Manufacturer:']/following-sibling::select[@id='mid']";
    public static final String ADVANCED_SEARCH_CHECKBOX="xpath=//input[@id='advs']";
    public static final String SUB_CATEGORY_CHECKBOX="xpath=//input[@id='isc']";
    public static final String SEARCH_RESULT="xpath=//div[@class='search-results']//div[@class='details']//a[contains(text(),'Apple MacBook Pro')]";
}
