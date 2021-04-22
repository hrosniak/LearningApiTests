import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class EmployeeTests {
    private static int id = 5;

    @Before
    public void SetUp() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }

    @Test

    public void GetAllEmployeeTests() {

        given()
                .when()
                    .get("/employees")
                .then()
                    .statusCode(200)
                    .log()
                        .all();
    }

    @Test

    public void GetSpeciificEmployee() {
        System.out.println("Id is equal to " + id);
        given()
                .when()
                    .get("/employee/" + id)
                .then()
                    .statusCode(200)
                    .log()
                        .all();
    }
    @Test

    public void PostCreateUser() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", "Testowy");
        jsonMap.put("salary", "500");
        jsonMap.put("age", "22");

        id =
        given()
                .when()
                    .contentType("application/json")
                    .body(jsonMap)
                    .post("/create")
                .then()
                    .statusCode(200)
                    .log()
                        .all()
                    .extract()
                        .path("data.id");

    }
}
