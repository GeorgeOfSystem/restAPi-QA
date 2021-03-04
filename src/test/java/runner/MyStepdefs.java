package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilsJson.JsonHelper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    Response response;
    Map<String,String> data =new HashMap<>();

    @Given("Access to Item Todo.ly")
    public void accessToItemTodoLy() {
        System.out.println("access Item todo.ly");
    }

    @Then("I hope the status code be {int}")
    public void iHopeTheStatusCodeBeInt(int statusCode) {
        response.then().
                statusCode(statusCode);
    }

    @And("I extract the {} to save on {}")
    public void iExtractTheIdeToSaveOnID_Item(String property, String nameVar) {
        data.put(nameVar,response.then().extract().path(property)+"");
    }

    @And("I hope the response body be")
    public void iHopeTheResponseBodyBe(String expectedBody) {
        //Compare the jsons
        System.out.println(response.getBody().asString());
        Assert.assertTrue("ERROR! los json no son iguales" , JsonHelper.areEqualJson(upadteUrlInformation(expectedBody),response.getBody().asString()));
    }

    // CREATE method
    @When("I send a POST requests to url {} with json")
    public void iSendAPOSTRequestsToUrlUrlWithJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                post(upadteUrlInformation(url));
        response.then().log().all();
    }

    //READ method
    @When("I send a GET request to url {} with json")
    public void iSendAGETRequestToUrlUrlWithJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                get(upadteUrlInformation(url));
        response.then().log().all();
    }

    //UPDATE method
    @When("I send a PUT request to url {} with json")
    public void iSendAPUTRequestToUrlUrlWithJson(String url, String body) {
        response =  given().
                auth().
                preemptive().
                basic("upb2021@upb.com","12345").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                put(upadteUrlInformation(url));
        response.then().log().all();
    }

    //DELETE method
    @When("I send a DELETE request to url {} with json")
    public void iSendADELETERequestToUrlUrlWithJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                delete(upadteUrlInformation(url));
        response.then().log().all();
    }

    public String upadteUrlInformation(String value){
        for( String key : data.keySet() ){
            value = value.replace(key,data.get(key));
        }
        return value;
    }
}
