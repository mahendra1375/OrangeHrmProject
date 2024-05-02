package Page.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        selectStausPicklistValue(Status);
        click(SearchBtn);
        Thread.sleep(5000);
    }
}
