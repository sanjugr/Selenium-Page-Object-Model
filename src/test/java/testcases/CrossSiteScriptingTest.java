package testcases;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageobjects.LandingPageObject;
import pageobjects.TaskDisplayPageObject;

public class CrossSiteScriptingTest extends TestBase {

    @Test
    public void crossSiteScriptingTest() throws InterruptedException{
        // page load is called from test base class
        LandingPageObject landing = new LandingPageObject(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(landing.brandName, "Fortinet"));

        // Adding task name without XSS and closing the alert
        landing.enterTaskName("<script>alert()</Script>");
        landing.enterDeadline("08/08/2021");
        landing.selectComplete(false);
        landing.addTask();
        Thread.sleep(3000); //Todo- Add Explict wait
        driver.switchTo().alert().dismiss();


        // Adding task name with XSS and checking if alert is not displayed
        landing.enterTaskName("<script>alert('XSS!')</Script>");
        landing.enterDeadline("08/08/2021");
        landing.selectComplete(false);
        landing.addTask();
        Thread.sleep(3000); //Todo- Add Explict wait

        // verifying tasks are displayed after adding
        TaskDisplayPageObject newTasks = new TaskDisplayPageObject(driver);
        wait.until(ExpectedConditions.visibilityOf(newTasks.displayedTaskList));

    }

}
