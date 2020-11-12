package testcases;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageobjects.LandingPageObject;
import pageobjects.TaskDisplayPageObject;

public class ButtonTest extends TestBase {

    @Test
    public void buttonTest() throws InterruptedException{

        // page load is called from test base class
        LandingPageObject landing = new LandingPageObject(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(landing.brandName, "Fortinet"));

        // Adding first  task1 with future due date and not completed
        landing.enterTaskName("TaskSelenium1");
        landing.enterDeadline("08/08/2021");
        landing.selectComplete(false);
        landing.addTask();
        Thread.sleep(2000); //Todo- Add Explict wait

        // Adding second new task2 future date and complete
        landing.enterTaskName("TaskSelenium2");
        landing.enterDeadline("08/08/2022");
        landing.selectComplete(true);
        landing.addTask();
        implicitWait();//Todo- Add Explict wait

        // verifying tasks are displayed after adding
        TaskDisplayPageObject newTasks = new TaskDisplayPageObject(driver);
        wait.until(ExpectedConditions.visibilityOf(newTasks.displayedTaskList));
        //Todo- add verification steps for pending button and complete button
        //Assert.assertTrue(newTasks.verifyTaskStatus());
    }

}
