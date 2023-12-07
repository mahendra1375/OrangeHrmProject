package PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends genericActions {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    @CacheLookup
    WebElement Uname;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement PWord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement LoginButton;


    public void enterUsername(String Username){

        waitClearEnterText(Uname,Username);

    }

    public void enterPassword(String Password){

        waitClearEnterText(PWord, Password);
    }

    public void clickLoginButton(){

        click(LoginButton);
    }

}
