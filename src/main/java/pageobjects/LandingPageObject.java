package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObject {

    WebDriver driver;

    @FindBy(className = "navbar-brand") public WebElement brandName;
    @FindBy(name = "name") public WebElement taskNameTextBox;
    @FindBy(name = "deadline") public WebElement deadlineTextBox;
    @FindBy(name = "complete") public WebElement completeCheckbox;
    @FindBy(id = "add-item") public WebElement addItemButton;
    @FindBy(className = "todo-content") public WebElement taskListHeader;

    // Constructor to pass teh driver and initialize all the webelements in the page object
    public LandingPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLandingPageTitle() {
        return driver.getTitle();
    }

    public void enterTaskName(String TaskName) {
        this.taskNameTextBox.clear();
        this.taskNameTextBox.sendKeys(TaskName);
    }

    public void enterDeadline(String deadlineDate) {
        this.deadlineTextBox.clear();
        this.deadlineTextBox.sendKeys(deadlineDate);
        this.taskListHeader.click();
    }

    public void selectComplete(Boolean check) {
        if (check) {
            if (!this.completeCheckbox.isSelected()) this.completeCheckbox.click();
        } else {
            if (this.completeCheckbox.isSelected()) this.completeCheckbox.click();
        }
    }

    public void addTask() {this.addItemButton.click(); }
}
