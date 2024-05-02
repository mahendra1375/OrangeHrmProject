package StepDefination;

import Page.Actions.genericActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;

import static StepDefination.Hooks.Configprop;
import static StepDefination.Hooks.driver;
public class genericSteps {

    @Given("user navigate to orangehrm url")
    public void userNavigateToOrangehrmUrl() {
        String URL=Configprop.getProperty("url");
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @And("logout from orange hrm")
    public void logoutFromOrangeHrm() {
        driver.manage().deleteAllCookies();
    }

}
