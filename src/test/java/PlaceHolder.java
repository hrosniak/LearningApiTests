import io.restassured.RestAssured;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PlaceHolder {

    @Before
    public void SetPlace(){ RestAssured.baseURI = "https://jsonplaceholder.typicode.com/"; }

    @Test
    public void album () {
        given()
                .when()
                    .get("/albums")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id", hasSize(100) )
                .log()
                    .all();

    }

    @Test
    public void albumGetId () {
        given()
                .when()
                    .get("/albums/5")
                .then()
                .statusCode(200)
                .assertThat()
                .body("title", new IsEqual<>("eaque aut omnis a"))
                .log()
                    .all();

    }

}
