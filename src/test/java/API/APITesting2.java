package API;

import API.config.TestConfig;
import org.testng.annotations.Test;
import API.utils.TokenUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class APITesting2 {




    @Test
    public void dummyJsonLimit5() {
        given()
                .queryParam("limit", 5)
                .when()
                    .get(TestConfig.dummyjson_base_url + TestConfig.products_endpoint)
                .then()
                    .statusCode(200)
                    .body("limit", equalTo(5));
    }

    @Test
    public void dummyJsonProductsSearch() {
        given()
                .queryParam("q", "phone")
                .when()
                    .get(TestConfig.dummyjson_base_url + TestConfig.search_endpoint)
                .then()
                    .statusCode(200);
    }

    @Test
    public void courseNameAPIAutomation() {
        given()
                .header("Course-Name", "API Automation")
                .when()
                    .get(TestConfig.httpbin_base_url + TestConfig.headers_endpoint)
                .then()
                    .statusCode(200)
                    .body("headers.Course-Name", equalTo("API Automation"));

    }


    @Test
    public void contentTypeVerification() {

        String payload = "{\n" +
                "  \"title\": \"API advanced session\",\n" +
                "  \"level\": \"beginner-intermediate\"\n" +
                "}";
        given()
                .body(payload)
                .header("Content-Type", "application/json")
                .when()
                .post(TestConfig.httpbin_base_url + "/post")
                .then()
                .statusCode(200)
                .body("headers.Content-Type", equalTo("application/json"))
                .body("json.title", equalTo("API advanced session"));
    }

    @Test
    public void basicAuthValidCredentials() {
        given()
                .auth()
                .basic("user", "passwd")
                .when()
                    .get(TestConfig.httpbin_base_url + "/basic-auth/user/passwd")
                .then()
                    .statusCode(200)
                .body("authenticated", equalTo(true))
                .body("user", equalTo("user"));
    }

    @Test
    public void basicAuthInvalidCredentials() {
        given()
                .auth()
                .basic("user", "wrongpass")
                .when()
                .get(TestConfig.httpbin_base_url + "/basic-auth/user/passwd")
                .then()
                .statusCode(401);
    }

    @Test
    public void accessToken() {
        String payload = "{\n" +
                "    \"username\": \"emilys\",\n" +
                "    \"password\": \"emilyspass\"\n" +
                "}";
       String accessToken = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.dummyjson_base_url + "/auth/login")
                .then()
                .statusCode(200)
                .body("accessToken", notNullValue())
                .extract()
                .path("accessToken");

        System.out.println(accessToken);
    }

    @Test
    public static void loginWithToken() {
        String token = TokenUtils.getAccessToken("emilys", "emilyspass");
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(TestConfig.dummyjson_base_url + "/auth/me")
                .then()
                .statusCode(200)
                .body("username", notNullValue())
                .body("email", notNullValue());
    }
}