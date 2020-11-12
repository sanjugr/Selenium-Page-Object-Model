package testcases;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LandingPageObject;
import pageobjects.TaskDisplayPageObject;

public class AddTaskWithPreviousDate extends TestBase {

        @Test
        public void addTaskWithPreviousDate() throws InterruptedException{

            // page load is called from test base class
            LandingPageObject landing = new LandingPageObject(driver);
            wait.until(ExpectedConditions.textToBePresentInElement(landing.brandName, "Fortinet"));

            // Adding first new task
            landing.enterTaskName("TaskSelenium1");
            landing.enterDeadline("08/08/2018");
            landing.selectComplete(false);
            landing.addTask();
            Thread.sleep(2000); //Todo- Add Explict wait


            // verifying tasks are displayed after adding
            TaskDisplayPageObject newTasks = new TaskDisplayPageObject(driver);
            newTasks.printAllDisplayedTasks();

            // verifying tasks name, date
            Assert.assertFalse(newTasks.verifyTaskDetailsAdded("TaskSelenium1"));
            Assert.assertTrue(newTasks.verifyTaskDetailsAdded("08/08/2018"));
        }
}
