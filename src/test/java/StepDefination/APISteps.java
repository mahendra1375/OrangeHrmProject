package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.maven.surefire.shared.io.input.TaggedReader;
import org.hamcrest.Matchers;
import org.testng.Assert;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.util.List;
import java.util.Map;
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
        System.out.println("ResponseBody: "+responseBody);
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

    @Given("Trigger book api request for schema Validation")
    public void triggerApiRequestForSchemaValidation() throws InterruptedException {

        System.out.println("Validation Start");

        given()
                .header("Content-Type", "application/json")
                .when().get("https://simple-books-api.glitch.me/books").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("booksSchema.json"));

        Thread.sleep(5000
        );
    }

    @Given("Trigger user api request for schema Validation")
    public void triggerUserApiRequestForSchemaValidation() {
        given()
                .header("Content-Type", "application/json")
                .when().get("https://petstore.swagger.io/v2/user/Mahendra1234").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"));


    }

    @Given("Trigger status api request for header Validation")
    public void triggerStatusApiRequestForHeaderValidation() {
       response= given()
                .when().get("https://simple-books-api.glitch.me/status").then().extract().response();

    }

    @Then("Validate single header")
    public void validateSingleHeader() {
    responseBody=response.asPrettyString();

    System.out.println("Response body: "+responseBody);

    String connection=response.header("Connection");
    System.out.println("connection: "+connection);

    String content_type=response.header("content-type");
    System.out.println("Content-type: "+content_type);


    }

    @Then("Validate multiple header")
    public void validateMultipleHeader() {
        Headers headers=response.headers();
        int i=1;
        for(Header x:headers){
            System.out.println("Header "+i+": "+x);
            i++;
        }
    }

    @Given("Trigger status api request for cookies Validation")
    public void triggerStatusApiRequestForCookiesValidation() {

        response=given()
                .when().get("https://www.google.com/").then().extract().response();

    }

    @Then("Validate single cookies")
    public void validateSingleCookies() {
        String AEC=response.getCookie("AEC");
        System.out.println("AEC: "+AEC);

        String NID=response.getCookie("NID");
        System.out.println("NID: "+NID);

    }

    @Then("Validate Multiple cookies")
    public void validateMultipleCookies() {
        Map<String, String> cookies=response.getCookies();

        for (String cookie:cookies.keySet()){

            System.out.println(cookie+": "+cookies.get(cookie));
        }

    }
}
