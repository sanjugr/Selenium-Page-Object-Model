package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ExcelReader;
import listeners.WebEventListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties config = new Properties();
    public WebDriver driver;
    public static EventFiringWebDriver event_driver;
    public static WebEventListener eventListener;
    public static FileInputStream fis;

    //Initializing the drivers executable paths
    private String userDir = System.getProperty("user.dir");
    private String chromeDriverPath = userDir + "\\src\\main\\resources\\driverexecutables\\chromedriver.exe";
    private String geckoDriverPath = userDir + "\\src\\main\\resources\\driverexecutables\\geckodriver.exe";

    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\main\\resources\\excelsheets\\testData.xlsx");
    public WebDriverWait wait;
    // function to read the property files
    private void readProperties() {
        // reading config files
        if (driver == null) {
            try {
                fis = new FileInputStream(userDir + "\\src\\main\\resources\\properties\\Config.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // function to select browser based on input from property file
    private void setup() {
        if (config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        } else if (config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
            driver = new FirefoxDriver();
        }

        event_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        event_driver.register(eventListener);
        driver = event_driver;

        wait = new WebDriverWait(driver, 30);
    }

    // launching and waiting for application
    private void launchApplication() {
        driver.manage().deleteAllCookies();
        driver.get(config.getProperty("testSiteUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
    }



    @BeforeSuite // Initializing all the functions before test is launched
    public void initTest() {
        this.readProperties();
        this.setup();
        this.launchApplication();
    }

    @AfterSuite
    public void teardown() {
        if (driver != null)
            driver.close();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

}



