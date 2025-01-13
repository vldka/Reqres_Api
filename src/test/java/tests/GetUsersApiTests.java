package tests;

import models.singleUser.SingleUserBodyResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.BaseSpec.getResponseSpecification;
import static specs.BaseSpec.requestSpec;

@Tag("API-TEST")
@DisplayName("Тестирование GET")
public class GetUsersApiTests extends TestBase {
    @Test
    @DisplayName("Проверка Api GET Single User")
    public void getRequestSuccefullTest() {
        SingleUserBodyResponse response =
                step("Отправляем запрос на информацию о пользователе", () ->
                        given(requestSpec)
                                .when()
                                .get("users/2")
                                .then()
                                .spec(getResponseSpecification(200))
                                .extract()
                                .as(SingleUserBodyResponse.class)
                );
        step("Проверяем поля id и text", () -> {
            assertEquals(2, response.getData().getId());
            assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.", response.getSupport().getText());
        });
    }

    @Test
    @DisplayName("Проверка Api GET Single User Отсутствует пользователь")
    public void getRequestNotFoundUserTest() {
        step("Проверка кода ошибки 404", () ->
                given(requestSpec)
                        .when()
                        .get("users/23")
                        .then()
                        .spec(getResponseSpecification(404))
        );
    }
}
