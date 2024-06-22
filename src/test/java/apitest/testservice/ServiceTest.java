package apitest.testservice;

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ServiceTest extends BaseService {

    public ServiceTest() {
        super();
    }

    @Test
    @Description("Get Method Google Status Code")
    public void getGoogleStatusCodeCheck() {
        given().spec(restAssFactory.getBaseApiRequest())
                .when()
                .get("/")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void postCrateNewAuth() {
        Response response =
                given()
                        .spec(restAssFactory.postApiRequest())
                        .when()
                        .post("/auth").then().extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String token = response.jsonPath().getJsonObject("token");
        System.out.println("Token: " + token);
    }
}
