package StepDefination;

import Page.Actions.LoginActions;
import io.cucumber.java.en.And;

import static StepDefination.Hooks.Configprop;
import static StepDefination.Hooks.driver;
public class LoginSteps {
    LoginActions LA= new LoginActions(driver);

    @And("User Login to orangeHrm")
    public void userLoginToOrangeHrm() throws InterruptedException {
        String Username=Configprop.getProperty("Username");
        String Password= Configprop.getProperty("Password");
        LA.logintoOrangeHrm(Username, Password);
        System.out.println("kiran");
        System.out.println("wadne");
    }
}
