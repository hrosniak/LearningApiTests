import io.restassured.RestAssured;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class Tests_Get {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void Test_1(){
        given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .statusCode(200)
                    .body("data.id[0]", new IsEqual(7))
                    .body("data.first_name", hasItems("Byron", "Lindsay", "Tobias"))
                    .log()
                        .all();
    }


}
