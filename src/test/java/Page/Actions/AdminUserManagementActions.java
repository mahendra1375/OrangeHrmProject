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
    public void userEnterDetails() throws InterruptedException {
       // waitForExpectedElement(UsernameTextBox, 30);
        waitClearEnterText(UsernameTextBox, "TheBoy");
        click(UserRoleDropdown);
        click(UserRole("Admin"));
        waitClearEnterText(EmployeeTextBox, "John Doe");
        click(EmpName);
        click(StatusDropdown);
        selectStausPicklistValue("Enabled");
        click(SearchBtn);
        Thread.sleep(5000);
    }
}
