package StepDefination;

import Page.Actions.AdminUserManagementActions;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.text.ParseException;

import static StepDefination.Hooks.driver;

public class AdminUserManagement {

    AdminUserManagementActions AdminUsermgt= new AdminUserManagementActions(driver);

    @And("user navigate to admin section")
    public void userNavigateToAdminSection() throws InterruptedException {
        AdminUsermgt.NavigatetoAdmin();
    }

    @When("user enter valid details")
    public void userEnterValidDetails() throws InterruptedException, IOException, ParseException {
        System.out.println("user entering valid details and click on search");
        AdminUsermgt.userEnterDetails();
    }

    @Then("verify search results")
    public void verifySearchResults() {
        System.out.println("verify search results");
    }
}
