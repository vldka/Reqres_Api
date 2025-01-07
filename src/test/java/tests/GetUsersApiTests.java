package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@Tag("API-TEST")
@DisplayName("Тестирование GET")
public class GetUsersApiTests extends TestBase {
    //GetRequestSingle getRequestSingle = new GetRequestSingle();
    @Test
    @DisplayName("Проверка Api GET Single User")
    public void testGetRequestSuccefull() {
        given()
                .when()
                .log().uri()
                .get("users/2")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.id", equalTo(2));
    }

    @Test
    @DisplayName("Проверка Api GET Single User Отсутствует пользователь")
    public void testGetRequestNotFoundUser() {
        given()
                .when()
                .log().uri()
                .get("users/23")
                .then()
                .log().body()
                .statusCode(404);
    }
}
