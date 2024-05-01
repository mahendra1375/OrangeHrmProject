package Page.Actions;

import org.openqa.selenium.WebDriver;
import static Page.Objects.LoginPage.*;
public class LoginActions extends genericActions {

    WebDriver driver;

    public LoginActions(WebDriver driver){
        super(driver);
    };
    public void logintoOrangeHrm() throws InterruptedException {
        waitClearEnterText(UserName_txt,"Admin");
        waitClearEnterText(Password_txt, "admin123");
        click(Login_Btn);
    }
}
