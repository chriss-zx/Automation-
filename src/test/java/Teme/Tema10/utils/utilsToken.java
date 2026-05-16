package Teme.Tema10.utils;

import Teme.Tema10.config.TestConfig;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;

public class utilsToken {

    public static String getToken(String user, String pass) {
        String payload = "{\n" +
                "    \"username\": \"" + user + "\",\n" +
                "    \"password\": \"" + pass + "\"\n" +
                "}";
        String token = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.dummyjson_base_url + "/auth/login")
                .then()
                .statusCode(200)
                .body("accessToken", notNullValue())
                .extract()
                .path("accessToken");

        return token;
    }
}
