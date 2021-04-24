import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test_POST {

    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>();

        map.put("name", "Hubert");
        map.put("job", "Tester");

        System.out.println(map);

        given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201)
                    .log()
                        .all();



    }



}
