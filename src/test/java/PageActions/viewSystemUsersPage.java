package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class viewSystemUsersPage extends genericActions {
    //public WebDriver driver;
    public viewSystemUsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement AdminTab;

    public void selectAdmin(){
        click(AdminTab);
    }

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement UsernameTextBox;

    public void enterUsername(String username){
        waitClearEnterText(UsernameTextBox, username);
    }

    @FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div/div/div/div")
    WebElement UserRoleDropdown;

    @FindBy(xpath = "//div[@role=\"option\"]//span[text()='Admin']")
    WebElement UserRoleAdmin;

    public void selectUserRole() throws InterruptedException {
        //UserRoleDropdown.click();
        click(UserRoleDropdown);
        click(UserRoleAdmin);
    }

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement EmplyeennameTextBox;

    @FindBy(xpath = "//div[@role='option']//span[text()='QA  QA']")
    WebElement EmpName;

    public void selectEmployeeName(String empname) throws InterruptedException {
        waitClearEnterText(EmplyeennameTextBox, empname);
        click(EmpName);
    }


    @FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div/div/div/div")
    WebElement statusDropdown;

    @FindBy(xpath = "//div[@role='option']//span[text()='Enabled']")
    WebElement StatusEnabeled;

    public void selectStatus() throws InterruptedException {
        click(statusDropdown);
        click(StatusEnabeled);
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    public void clickSearchButton(){
        //searchButton.click();
        click(searchButton);
    }

    @FindBy(xpath = "//p[text()='Employee Distribution by Location']")
    WebElement scrollGraph;

    public void viewScrollEmpGraph() throws InterruptedException {
        waitForExpectedElement(scrollGraph,20);
        scrollIntoView_Element(scrollGraph);
    }

}
