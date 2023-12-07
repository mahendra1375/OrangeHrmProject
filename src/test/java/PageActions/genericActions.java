package PageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class genericActions {
    static WebDriver driver;

    public void waitForExpectedElement(WebElement elementName, long waitTimeSeconds){
       WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(waitTimeSeconds));
       wait.until(ExpectedConditions.visibilityOf(elementName));
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


}
