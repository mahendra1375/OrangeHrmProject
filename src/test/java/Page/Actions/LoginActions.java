package Page.Actions;

import org.openqa.selenium.WebDriver;
import static Page.Objects.LoginPage.*;
public class LoginActions extends genericActions {

    WebDriver driver;

    public LoginActions(WebDriver driver){
        super(driver);
    };
    public void logintoOrangeHrm(String Username, String Password) throws InterruptedException {
        waitClearEnterText(UserName_txt, Username);
        waitClearEnterText(Password_txt, Password);
        click(Login_Btn);
    }
}
