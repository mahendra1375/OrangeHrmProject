package Page.Actions;


import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

public class genericActions {
    WebDriver driver;
    Scenario scenario;

    public genericActions(WebDriver driver){

        this.driver=driver;
    }

    public void waitForExpectedElement(WebElement elementName, long waitTimeSeconds){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
        wait.until(ExpectedConditions.visibilityOf(elementName));
    }

    public void waitForExpectedElement(By by, long waitTimeSeconds){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
        wait.until(ExpectedConditions.visibilityOf((WebElement) by));
    }

    public void waitForExpectedElement(By by){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf((WebElement) by));
    }

    public void scrollIntoView_Element(WebElement elementName){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.elementToBeClickable(elementName)));
    }

    public void click(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public  void jsClick(WebElement element){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitClearEnterText(WebElement element, String value){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement text_Box=wait.until(ExpectedConditions.elementToBeClickable(element));
        text_Box.click();
        text_Box.clear();
        text_Box.sendKeys(value);
    }

    public void waitClearEnterText(By by, String value){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement text_Box=wait.until(ExpectedConditions.elementToBeClickable(by));
        text_Box.click();
        text_Box.clear();
        text_Box.sendKeys(value);
    }

    public void  mouserhover(By by){
        Actions act = new Actions(driver);
        act.moveToElement((WebElement) by).keyDown(Keys.ENTER);
    }

    public void captureScreenShot(String screnshhotName){
        TakesScreenshot TSS = (TakesScreenshot) driver;
        byte[] screenshot = TSS.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png", screnshhotName);
    }
}
