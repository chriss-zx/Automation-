package Teme.Tema10.tests;

import Teme.Tema10.config.TestConfig;
import Teme.Tema10.data.TestData;
import Teme.Tema10.utils.utilsToken;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class Exercitii {

    @Test
    public void ex1() {
        given()
                .when()
                .get(TestConfig.fakestoreapi_base_url + TestConfig.products_endpoint + "/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("price", greaterThan(0F));
    }

    @Test
    public void ex2() {
        given()
                .when()
                .get(TestConfig.fakestoreapi_base_url + TestConfig.products_endpoint)
                .then()
                .body("size()", greaterThan(0))
                .body("title", notNullValue())
                .body("category", notNullValue())
                .body("image", notNullValue());
    }

    @Test
    public void ex3() {
        String title = "Tema10";
        String category = "API testing";
        String payload = "{\n" +
                "    \"title\": \"" + title + "\",\n" +
                "    \"price\": 777.77,\n" +
                "    \"description\": \"Your perfect pack for everyday use and walks in the forest.\",\n" +
                "    \"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png\",\n" +
                "    \"category\": \"" + category + "\"\n" +
                "}";

        System.out.println(payload);
        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.fakestoreapi_base_url + TestConfig.products_endpoint)
                .then()
                .statusCode(201)
                .body("title", equalTo(title))
                .body("category", equalTo(category));
    }

    @Test
    public void ex4() {
        given()
                .queryParam("limit", 5)
                .when()
                .get(TestConfig.dummyjson_base_url + TestConfig.products_endpoint)
                .then()
                .statusCode(200)
                .body("limit", equalTo(5))
                .body("products.size()", equalTo(5));
    }

    @Test
    public void ex5() {
        given()
                .queryParam("q", "phone")
                .when()
                .get(TestConfig.dummyjson_base_url + TestConfig.search_endpoint)
                .then()
                .statusCode(200)
                .body("size()", notNullValue())
                .body("products[0].title", notNullValue())
                .body("products[0].price", notNullValue());
    }

    @Test
    public void ex6() {
        given()
                .header("Course-Name", "API Automation")
                .when()
                .get(TestConfig.httpbin_base_url + TestConfig.headers_endpoint)
                .then()
                .statusCode(200)
                .body("headers.Course-Name", equalTo("API Automation"));
    }

    @Test
    public void ex7() {
        given()
                .auth()
                .basic("user", "passwd")
                .when()
                .get(TestConfig.httpbin_base_url + "/basic-auth/user/passwd")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }

    @Test
    public void ex8() {

        String payload = "{\n" +
                "    \"username\": \"emilys\",\n" +
                "    \"password\": \"emilyspass\"\n" +
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

        System.out.println(token);
    }

    @Test
    public void ex8_Login() {
        String token = utilsToken.getToken(TestData.username, TestData.password);
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
