import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class Users {
    private static String name;

    @Before
    public void SetUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void ChceckIfClientNumberTwoExist() {
        name =
        given()
                .when()
                    .get("/api/users/2")
                .then()
                    .statusCode(200)
                    .log()
                        .all()
                    .extract()
                        .path("data.first_name");



    }

    @Test
    public void CheckIfMemberCanBeCreated() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", name);
        jsonMap.put("job", "Trener");
        given()
                .when()
                    .contentType("application/json")
                    .body(jsonMap)
                    .post("/api/users/2")
                .then()
                    .statusCode(201)
                    .body("name", equalTo(name))
                    .log()
                        .all();
    }
}
