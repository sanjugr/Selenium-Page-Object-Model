package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class SeleniumBase extends TestBase {

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /*Select using WebElements*/

    /**
     * To Wait Until Element to be Clickable
     */
    public void explicitWaitElementToBeClickable(WebElement element, long timeInSeconds) {
        WebDriverWait clickableWait = new WebDriverWait(driver, (timeInSeconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public void explicitWaitElementToBeSelected(WebElement element, long timeInSeconds) {
        WebDriverWait selectableWait = new WebDriverWait(driver, (timeInSeconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Element has the text
     */
    public void explicitWaitTextToBePresentInElement(WebElement element, long timeInSeconds, String text) {
        WebDriverWait textToBePresent = new WebDriverWait(driver, (timeInSeconds));
        textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    /**
     * To Wait Until Title contains the text
     */
    public void explicitWaitTitleContains(WebElement element, long timeInSeconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(driver, (timeInSeconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public void explicitWaitTitleIs(long timeInSeconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(driver, (timeInSeconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public void explicitWaitVisibilityOfElement(WebElement element, long timeInSeconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, (timeInSeconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public void explicitWaitSelectionStateToBe(WebElement element, long timeInSeconds, boolean selected) {
        WebDriverWait elementIsSelected = new WebDriverWait(driver, (timeInSeconds));
        elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait Until Elements to be Visible
     */
    public void explicitWaitVisibilityOfElements(List<WebElement> element, long timeInSeconds) {
        WebDriverWait elementsToBeVisible = new WebDriverWait(driver, (timeInSeconds));
        elementsToBeVisible.until(ExpectedConditions.visibilityOfAllElements(element));
    }


    /*Select using By Method*/

    /**
     * To Wait Until Element to be Clickable
     */
    public void explicitWaitElementToBeClickable(By element, long timeInSeconds) {
        WebDriverWait clickableWait = new WebDriverWait(driver, (timeInSeconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public void explicitWaitElementToBeSelected(By element, long timeInSeconds) {
        WebDriverWait selectableWait = new WebDriverWait(driver, (timeInSeconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Title contains the text
     */
    public void explicitWaitTitleContains(By element, long timeInSeconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(driver, (timeInSeconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public void explicitWaitTitleIs(By element, long timeInSeconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(driver, (timeInSeconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public void explicitWaitVisibilityOfElement(By element, long timeInSeconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, (timeInSeconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public void explicitWaitSelectionStateToBe(By element, long timeInSeconds, boolean selected) {
        WebDriverWait elementToBeVisible = new WebDriverWait(driver, (timeInSeconds));
        elementToBeVisible.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait for the Alert
     */
    public void explicitWaitForAlert(long timeInSeconds) {
        WebDriverWait waitForAlert = new WebDriverWait(driver, (timeInSeconds));
        waitForAlert.until(ExpectedConditions.alertIsPresent());
    }


}
