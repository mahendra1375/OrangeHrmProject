package Page.Objects;

import org.openqa.selenium.By;

public class AdminUserManagement {

    public static By AdminTab= By.xpath("//span[text()='Admin']");
    public static By UsernameTextBox= By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input");
    public static By UserRoleDropdown = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div/div/div");
    public static By UserRole(String RoleType){
        By UserRole= By.xpath("//div[@role='option']//span[text()='" + RoleType + "']");
        return UserRole;
    }
    public static By EmployeeTextBox= By.xpath("//input[@placeholder='Type for hints...']");
    public static By EmpName= By.xpath("//div[@role='option']//span[1]");
    public static By StatusDropdown= By.xpath("//label[text()='Status']/parent::div/following-sibling::div/div/div/div");
    public static By SearchBtn = By.xpath("//button[@type='submit']");
}
