package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ComputersPageUI;

public class ComputersPageObject extends BasePage {
    WebDriver driver;
    public ComputersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public DesktopsPageObject clickToDesktopsLink() {
        waitForElementVisibile(driver, ComputersPageUI.DESKTOPS_LINK);
        clickToElement(driver, ComputersPageUI.DESKTOPS_LINK);
        return PageGeneratorManager.getDesktopInfoPage(driver);
    }

    public NotebooksPageObject clickToNotebooksLink() {
        waitForElementVisibile(driver, ComputersPageUI.NOTEBOOKS_LINK);
        clickToElement(driver, ComputersPageUI.NOTEBOOKS_LINK);
        return PageGeneratorManager.getNotebooksPage(driver);
    }
}
