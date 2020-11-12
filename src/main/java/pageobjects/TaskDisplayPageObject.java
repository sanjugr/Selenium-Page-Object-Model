package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TaskDisplayPageObject {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = ".list-container ul.ui-sortable li")
    public WebElement displayedTaskList;

    // Constructor to pass teh driver and initialize all the webelements in the page object
    public TaskDisplayPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, 30);
    }

    public List<WebElement> getAllTaskElements() {
        List<WebElement> myItems = driver.findElements(By.cssSelector(".list-container ul.ui-sortable li"));
        return myItems;
    }


    public int getTotalTasksDisplayed() {
        return this.getAllTaskElements().size();
    }

    public void waitTillNewTaskIsAdded() {
        wait.until(ExpectedConditions.stalenessOf(displayedTaskList));
    }

    public void printAllDisplayedTasks() {
        List<WebElement> myItems = this.getAllTaskElements();
        for (WebElement element : myItems) {
            System.out.println(element.getText());
        }
    }

    public boolean verifyTaskDetailsAdded(String TaskDetails) {
        List<WebElement> myTasks = this.getAllTaskElements();
        WebElement newlyAddedTask = myTasks.get(myTasks.size() - 1);
        if (newlyAddedTask.getText().contains(TaskDetails))
            return true;
        else
            return false;
    }

    //Todo-Modify the below function to be more stable
    public boolean verifyTaskStatus() {
        List<WebElement> myTasks = this.getAllTaskElements();
        WebElement newlyAddedTask = myTasks.get(myTasks.size() - 1);
        if (newlyAddedTask.findElement(By.className(".status")).getText().contains("complete"))
            return true;
        else
            return false;
    }
}


