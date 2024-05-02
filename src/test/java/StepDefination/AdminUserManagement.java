package StepDefination;

import Page.Actions.AdminUserManagementActions;
import io.cucumber.java.en.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

import static StepDefination.Hooks.driver;

public class AdminUserManagement {

    AdminUserManagementActions AdminUsermgt= new AdminUserManagementActions(driver);

    @And("user navigate to admin section")
    public void userNavigateToAdminSection() throws InterruptedException {
        AdminUsermgt.NavigatetoAdmin();
    }

    @When("user enter valid details")
    public void userEnterValidDetails() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        System.out.println("user entering valid details and click on search");
        String jsonpath="./src/test/java/OrgHrmData/searchUser_Data.json";
        JSONParser parser= new JSONParser();
        Reader reader= new FileReader(jsonpath);
        JSONObject jsonObject= (JSONObject) parser.parse(reader);
        String UserName= (String) jsonObject.get("Username");
        String UserRole= (String) jsonObject.get("UserRole");
        String EmpName= (String) jsonObject.get("Employee Name");
        String Status= (String) jsonObject.get("Status");
        AdminUsermgt.userEnterDetails(UserName, UserRole, EmpName, Status);
    }

    @Then("verify search results")
    public void verifySearchResults() {
        System.out.println("verify search results");
    }
}
