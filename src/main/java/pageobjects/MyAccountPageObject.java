package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    // WebElement Locators is initiliazed below
    @FindBy(className = "info-account") WebElement myAccountInfo;

    // Constructor to pass teh driver and initialize all the webelemtns in the page object
    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public String getMyAccountInfo() {
        return myAccountInfo.getText();
    }
}