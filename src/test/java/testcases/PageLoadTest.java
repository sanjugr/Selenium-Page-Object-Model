package testcases;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LandingPageObject;

public class PageLoadTest extends TestBase {

    /*
    * Test 1 ( Application Load Test )Verify that the task website is launched and the following elements are displayed
     * */
    @Test
    public void pageLoadTest() {

        // page load is called from test base class
        LandingPageObject landing = new LandingPageObject(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(landing.brandName, "Fortinet"));

        //verify if the elements are displayed in the login page
        Assert.assertEquals(true, landing.brandName.isDisplayed());
        Assert.assertEquals(true, landing.taskNameTextBox.isDisplayed());
        Assert.assertEquals(true, landing.deadlineTextBox.isDisplayed());
        Assert.assertEquals(true, landing.completeCheckbox.isDisplayed());
        Assert.assertEquals(true, landing.addItemButton.isDisplayed());

    }
}
