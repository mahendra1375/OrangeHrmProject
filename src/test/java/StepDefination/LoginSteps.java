package StepDefination;

import Page.Actions.LoginActions;
import io.cucumber.java.en.And;
import static StepDefination.Hooks.driver;
public class LoginSteps {
    LoginActions LA= new LoginActions(driver);

    @And("User Login to orangeHrm")
    public void userLoginToOrangeHrm() throws InterruptedException {
        LA.logintoOrangeHrm();
    }
}
