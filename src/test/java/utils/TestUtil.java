package utils;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    private static String userDir = System.getProperty("user.dir");
    public static String screenshotName;


    public static void takeErrorScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotName ="error";
        FileUtils.copyFile(scrFile, new File(userDir + "/screenshots/exception" + System.currentTimeMillis() + ""+screenshotName+".png"));
    }
}
