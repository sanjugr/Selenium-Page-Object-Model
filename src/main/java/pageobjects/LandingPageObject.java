package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObject {

    WebDriver driver;

    @FindBy(className = "login") public WebElement loginButton;

    // Constructor to pass teh driver and initialize all the webelements in the page object
    public LandingPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLandingPageTitle() {
        return driver.getTitle();
    }

    public void navigateToLoginPage(){
    loginButton.click();
}
}
