package testcases.standalonetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class GoogleSearchTest {

    private String userDir = System.getProperty("user.dir");
    private String chromeDriverPath = userDir + "\\src\\main\\resources\\driverexecutables\\chromedriver.exe";
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void verifySearchButton() {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));
        String text = search_button.getAttribute("value");
        Assert.assertEquals(text, search_text, "Text not found!");

    }
}