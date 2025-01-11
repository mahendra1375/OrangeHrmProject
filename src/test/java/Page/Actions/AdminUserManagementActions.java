package Page.Actions;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.Scenario;
import java.util.ArrayList;
import java.util.Set;

import static Page.Objects.AdminUserManagement.*;

public class AdminUserManagementActions extends genericActions {


    public AdminUserManagementActions(WebDriver driver) {
        super(driver);
    }

    public void NavigatetoAdmin(){
        //waitForExpectedElement(AdminTab, 30);
        click(AdminTab);
        captureScreenShot("ScreenShot");
    }

    public void selectStausPicklistValue(String PickListValue){
        String xpath= "//div[@role='option']//span[text()='" + PickListValue + "']";
        click(By.xpath(xpath));
    }
    public void userEnterDetails(String UserName, String UserRole, String EmployeeName, String Status) throws InterruptedException {
       // waitForExpectedElement(UsernameTextBox, 30);
        waitClearEnterText(UsernameTextBox, UserName);
        click(UserRoleDropdown);
        click(UserRole(UserRole));
        waitClearEnterText(EmployeeTextBox, EmployeeName);
        click(EmpName);
        click(StatusDropdown);
        String firstName= "Mahendra";
        selectStausPicklistValue(Status);
        click(SearchBtn);
        Thread.sleep(5000);
        //((JavascriptExecutor) driver).executeAsyncScript("window.open()");
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(5000);
        Set<String> tab =driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(tab);
        driver.switchTo().window(tabs.get(0));
        driver.get("https://www.way2automation.com/way2auto_jquery/");
        Thread.sleep(5000);


    }


}
