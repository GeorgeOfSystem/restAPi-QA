package basicRestAssured;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CRUDProjectTest {
    @Test
    public void verify_crud_project(){
        //Create, we need to get the id
        //Read
        //Update
        //Delete
        given().
                auth().
                preemptive().
                basic("upb2021@upb.com","12345").
                log().
                all().
                when().
                get("http://todo.ly/api/projects.json").
                then().
                log().
                all();
    }
}
