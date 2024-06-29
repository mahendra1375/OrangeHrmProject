package Page.Actions;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
        ((JavascriptExecutor) driver).executeAsyncScript("window.open()");
        Thread.sleep(5000);
       // Set<String> tabs =driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.get("https://www.way2automation.com/way2auto_jquery/");
        Thread.sleep(5000);
    }


}
