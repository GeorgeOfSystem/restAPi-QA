package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefs {
    Response response;

    @Given("Access to Todo.ly")
    public void accessToTodoLy() {
        System.out.println("acceso al todo.ly");
    }

    @When("I send a POST request to url  {} with json")
    public void iSendAPOSTRequestToUrlHttpsTodoLyApiItemsJsonWithJson(String url,String body) {
        response =  given().
                auth().
                preemptive().
                basic("upb2021@upb.com","12345").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                post(url);
    }

    @Then("I hope the status code be {int}")
    public void iHopeTheStatusCodeBe(int arg0) {
        response.then().
                statusCode(arg0);
    }

    @And("I hope the Content of the project be {string}")
    public void iHopeTheContentOfTheProjectBe(String arg0) {
        response.then().body("Content",equalTo(arg0));
    }
}
