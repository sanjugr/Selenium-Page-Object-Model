package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject  {

    private WebDriver driver;
    private WebDriverWait wait ;

    // WebElement Locators is initiliazed below
    @FindBy(id = "email") WebElement emailTextBox;
    @FindBy(id = "passwd") WebElement passwordTextBox;
    @FindBy(name = "SubmitLogin") WebElement submitLoginButton;

    // Constructor to pass teh driver and initialize all the webelemtns in the page object
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void login(String email, String password){
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        submitLoginButton.click();
    }
}