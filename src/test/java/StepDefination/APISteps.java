package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;


public class APISteps {

    String responseBody;
    Response response;
    @Given("Trigger api request to create user")
    public void triggerApiRequestToCreateUser() {

        RestAssured.baseURI="https://reqres.in";
        String requestBody="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        response=given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "BearerToken")
                    .auth().oauth2("Token")
                    .body(requestBody)
                .when()
                    .post("api/users")
                .then().log().all()
                    .extract().response();
    }

    @And("Extract response")
    public void extractResponse() {
        
        responseBody=response.asPrettyString();
    }

    @Then("Validate Status code is {string}")
    public void validateStatusCodeIs(String arg0) {
        int ActualstatusCode=response.getStatusCode();
        System.out.println("Staus code received is TEst : " +ActualstatusCode);
        System.out.println("this is test statement");
        Assert.assertEquals(ActualstatusCode, 201);

        long Response_Time= response.getTime();
        System.out.println("Response Time is: "+Response_Time);

        String Server_val=response.header("Server");
        System.out.println("Server in Response Header: "+Server_val);

        System.out.println("kishor1");
        System.out.println("kishor4");
        System.out.println("Wabale");
        System.out.println("Automation Engineer");

    }

    @Then("Validate response Body")
    public void validateResponseBody() {

        JsonPath jsp = new JsonPath(responseBody);
        String resName=jsp.getString("name");
        String resJob=jsp.getString("job");
        String resId=jsp.getString("id");
        String resDate=jsp.getString("createdAt");

        System.out.println("Name in response : " +resName);
        Assert.assertEquals(resName,"morpheus");

        System.out.println("Job in response : " +resJob);
        Assert.assertEquals(resJob,"leader");

        System.out.println("Id in response : " +resId);
        System.out.println("Date in response : " +resDate);

    }
}
