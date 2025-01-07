package tests;

import models.lombok.singleUser.SingleUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("API-TEST")
@DisplayName("Тестирование GET")
public class GetUsersApiTests extends TestBase {
    @Test
    @DisplayName("Проверка Api GET Single User")
    public void testGetRequestSuccefull() {
        SingleUserResponse response =
                step("Отправляем запрос на информацию о пользователе", () ->
                        given()
                                .when()
                                .log().uri()
                                .get("users/2")
                                .then()
                                .statusCode(200)
                                .log().body()
                                .extract()
                                .as(SingleUserResponse.class)
                );
        step("Проверяем поля id и text", () -> {
            assertEquals(2, response.getData().getId());
            assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.", response.getSupport().getText());
        });
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
