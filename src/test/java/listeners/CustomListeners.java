package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.*;

/**
 * This is a listener class wrapper to implement custom actions on/before/after each test actions
 */
public class CustomListeners implements ITestListener {

    public String errorScreenshotPath = "C:\\Sanju\\Technical Materials\\GenericSeleniumFramework\\src\\screenshots\\error.png";

    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }


    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }


    public void onTestFailure(ITestResult arg0) {
        System.setProperty("org.uncommons.reportng.excape-output", "false");
      /*  try {
            TestUtil.takeErrorScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Reporter.log("Test failed - Capturing Screenshots");
        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\""+errorScreenshotPath+"\">Screenshot</a>");

    }


    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }


    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult arg0) {
        //For generating ReportNg reports
        Reporter.log("Test Passed - Capturing Screenshots");

    }
}
