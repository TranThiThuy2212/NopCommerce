package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;
    protected final Log log;
    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
    }
    protected BaseTest()
    {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName){
        System.out.println("Run on" + browserName);
        if(browserName.equals("firefox")){
            driver = WebDriverManager.firefoxdriver().create();
            driver =new FirefoxDriver();
        } else if(browserName.equals("chrome")){
            driver =WebDriverManager.chromedriver().create();
            driver =new ChromeDriver();
        }else if(browserName.equals("edge")){
            driver =WebDriverManager.edgedriver().create();
            driver =new EdgeDriver();
        }else{
            throw new RuntimeException("Brower name invalid");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.USER_PAGE_URL);
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String appUrl){
        System.out.println("Run on" + browserName);
        if(browserName.equals("firefox")){
            driver = WebDriverManager.firefoxdriver().create();
            driver =new FirefoxDriver();
        } else if(browserName.equals("chrome")){
            driver =WebDriverManager.chromedriver().create();
            driver =new ChromeDriver();
        }else if(browserName.equals("edge")){
            driver =WebDriverManager.edgedriver().create();
            driver =new EdgeDriver();
        }else{
            throw new RuntimeException("Brower name invalid");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }


    public WebDriver getDriver() {
        return driver;
    }


    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int ganarateNumber() {
        return new Random().nextInt(9999);
    }
}