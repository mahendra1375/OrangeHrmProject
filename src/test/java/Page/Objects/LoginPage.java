package Page.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static  By UserName_txt= By.xpath("//input[@placeholder='Username']");
    public static  By Password_txt= By.xpath("//input[@placeholder='Password']");
    public static  By Login_Btn= By.xpath("//button[@type='submit']");
}
