package StepDefination;
import PageActions.LoginPage;
import PageActions.viewSystemUsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import static StepDefination.Hooks.Configprop;
import static StepDefination.Hooks.driver;

public class Admin_Steps {
    public LoginPage lp;

    public viewSystemUsersPage vsu;

    @Given("user navigate to orangehrm url")
    public void userNavigateToOrangehrmUrl() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        lp= new LoginPage(driver);
        vsu = new viewSystemUsersPage(driver);
        Thread.sleep(5000);
        String Uname= (String) Configprop.get("Username");
        String PWord= Configprop.getProperty("Password");
        lp.enterUsername(Uname);
        lp.enterPassword(PWord);
        lp.clickLoginButton();
    }

    @And("user navigate to admin section")
    public void userNavigateToAdminSection() throws InterruptedException {
        vsu.viewScrollEmpGraph();
        vsu.selectAdmin();
        System.out.println("Admin option Selected");
    }

    @When("user enter valid details")
    public void userEnterValidDetails() throws InterruptedException, IOException, ParseException {
        String jsonpath="./src/test/OraneHrmData/searchUser_Data.json";
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(jsonpath);
        JSONObject jsonObject=(JSONObject) parser.parse(reader);
        String Username= (String) jsonObject.get("Usename");
        String EmpName= (String) jsonObject.get("Employee Name");
        vsu.enterUsername(Username);
        vsu.selectUserRole();
        vsu.selectEmployeeName(EmpName);
        vsu.selectStatus();
        vsu.clickSearchButton();
        Thread.sleep(5000);
        System.out.println("user entered valid details and click on search");
    }

    @Then("verify search results")
    public void verifySearchResults() {
        System.out.println("verify search results");
    }


    @And("logout from orange hrm")
    public void logoutFromOrangeHrm() {
        driver.quit();
    }
}
