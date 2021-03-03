package IteamProject;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CRUDItems {
    private Response response;

    @Test
    public void verifyItemsCRUD(){
        JSONObject body = new JSONObject();
        body.put("Content","CRUD Items");

        //CREATE
        response = given().
                        auth().
                        preemptive().
                        basic("upb2021@upb.com","12345").
                        contentType(ContentType.JSON).
                        body(body.toString()).
                        log().
                        all().
                when().
                        post("http://todo.ly/api/items.json");
        response.then().
                statusCode(200).
                body("Content",equalTo("CRUD Items")).
                body("Deleted",equalTo("false")).
                log().
                all();
        //READ
        response = given().
                    auth().
                    preemptive().
                    basic("upb2021@upb.com","12345").
                    contentType(ContentType.JSON).
                    body(body.toString()).
                    log().
                    all().
                when().
                    get("http://todo.ly/api/items.json");

        response.then().
                statusCode(200).
                body("Content",equalTo("CRUD Items")).
                body("Deleted",equalTo("false")).
                log().
                all();

        //Extract id
        int idItem = response.then().extract().path("Id");
        //UPDATE
        body.put("Content","RESTAsured UPDATE");
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com","12345").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().
                when().
                put("http://todo.ly/api/items"+idItem+".json");

        response.then().
                statusCode(200).
                body("Content",equalTo("CRUD Items")).
                body("Deleted",equalTo("false")).
                log().
                all();
        //DELETE
        response = given().
                auth().
                preemptive().
                basic("upb2021@upb.com","12345").
                contentType(ContentType.JSON).
                body(body.toString()).
                log().
                all().
                when().
                delete("http://todo.ly/api/items"+idItem+".json");

        response.then().
                statusCode(200).
                body("Content",equalTo("CRUD Items")).
                body("Deleted",equalTo("true")).
                log().
                all();
    }
}
