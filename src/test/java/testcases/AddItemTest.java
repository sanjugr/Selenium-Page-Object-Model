package testcases;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LandingPageObject;
import pageobjects.TaskDisplayPageObject;

public class AddItemTest extends TestBase {

    @Test
    public void addItemTest() throws InterruptedException{
        // page load is called from test base class
        LandingPageObject landing = new LandingPageObject(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(landing.brandName, "Fortinet"));

        // Adding first new task
        landing.enterTaskName("TaskSelenium1");
        landing.enterDeadline("08/08/2020");
        landing.selectComplete(false);
        landing.addTask();
        Thread.sleep(2000); //Todo- Add Explict wait

        // Adding second new task
        landing.enterTaskName("TaskSelenium2");
        landing.enterDeadline("08/08/2021");
        landing.selectComplete(true);
        landing.addTask();
        Thread.sleep(2000);//Todo- Add Explict wait


        // verifying tasks are displayed after adding
        TaskDisplayPageObject newTasks = new TaskDisplayPageObject(driver);
        wait.until(ExpectedConditions.visibilityOf(newTasks.displayedTaskList));
        newTasks.printAllDisplayedTasks();

        // verifying tasks name, date
        Assert.assertTrue(newTasks.verifyTaskDetailsAdded("TaskSelenium2"));
        Assert.assertTrue(newTasks.verifyTaskDetailsAdded("08/08/2021"));

    }
}
