package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    static WebDriver driver;
    public static Properties Configprop;
    @Before
    public static void browsersetUp () throws IOException {
        Configprop= new Properties();
        FileInputStream Fis= new FileInputStream("./src/test/OrangeHrmConfigFiles/orangeHrmconfig.properties");
        Configprop.load(Fis);
        String Br=Configprop.getProperty("Browser");
        if (Br.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\IdeaProjects\\OrangeHrmProject\\src\\test\\resources\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("Browser Not matched");
        }
    }


    @After(order = 2)
    public void Takescreenshot(Scenario SC){
        if (SC.isFailed()){
            TakesScreenshot TSS= (TakesScreenshot) driver;
            byte [] screenshot=TSS.getScreenshotAs(OutputType.BYTES);
            SC.attach(screenshot,"image/png", "Failed scenario screeshot");
        }
        System.out.println("Taking screensot for failure step");
    }

    @After(order = 1)
    public static void closeBrowser(){
        driver.quit();
        System.out.println("Closing the browser");
    }
}
