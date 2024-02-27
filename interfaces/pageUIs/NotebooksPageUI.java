package pageUIs;

public class NotebooksPageUI {
    public static final String SORT_BY_DROPDOWN="xpath=//select[@id='products-orderby']";
    public static final String SORT_AND_DISPLAY_BY_NAME ="xpath=//div[@class='details']/h2/a";
    public static final String SORT_BY_PRICE="xpath=//div[@class='details']/div[@class='add-info']/div/span";
    public static final String DISPLAY_DROPDOWN="xpath=//select[@id='products-pagesize']";
    public static final String PAGE_ONE="xpath=//li[@class='current-page']/span[text()='1']";
    public static final String PAGE_TWO="xpath=//li[@class='individual-page']/a[text()='2']";
    public static final String NEXT_PAGE_ICON="xpath=//li[@class='next-page']/a[text()='Next']";
    public static final String PREVIOUS_PAGE_ICON="xpath=//li[@class='previous-page']/a[text()='Previous']";
    public static final String NAME_PRODUCT ="xpath=//div[@class='details']/h2/a[text()='%s']";
}
