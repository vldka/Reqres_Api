package tests;

import io.restassured.http.ContentType;
import models.login.LoginRequestBody;
import models.login.LoginResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.BaseSpec.*;

@Tag("API-TEST")
@DisplayName("Тестирование Post")
public class PostLoginTests extends TestBase {
    @Test
    @DisplayName("Проверка Api Post Login")
    public void testPostRegistration() {
        LoginRequestBody authData = new LoginRequestBody();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");
        LoginResponseBody response =
                step("Отправляем запрос на авторизацию", () ->
                        given(requestSpec)
                                .body(authData)
                                .contentType(ContentType.JSON)
                                .when()
                                .post("login")
                                .then()
                                .spec(getResponseSpecification(200))
                                .extract()
                                .as(LoginResponseBody.class));
        step("Проверяем token на заполнение", () ->
                assertThat(response.getToken()).isNotNull());
    }

    @Test
    @DisplayName("Проверка Api Post Login Ошибка UserNotFound")
    public void testPostRegistrationUserNotFound() {
        LoginRequestBody authData = new LoginRequestBody();
        authData.setEmail("eve.holt@reqres");
        authData.setPassword("cityslicka");
        LoginResponseBody response =
                step("Отправляем запрос на авторизацию", () ->
                        given(requestSpec)
                                .body(authData)
                                .when()
                                .log().uri()
                                .post("login")
                                .then()
                                .log().body()
                                .spec(getResponseSpecification(400))
                                .extract()
                                .as(LoginResponseBody.class));
        step("Проверяем ошибку user not found", () ->
                assertEquals("user not found", response.getError()));
    }

    @Test
    @DisplayName("Проверка Api Post Login Ошибка MissingPassword")
    public void testPostRegistrationMissingPassword() {
        LoginRequestBody authData = new LoginRequestBody();
        authData.setEmail("peter@klaven");
        LoginResponseBody response =
                given(requestSpec)
                        .body(authData)
                        .when()
                        .post("login")
                        .then()
                        .spec(getResponseSpecification(400))
                        .extract()
                        .as(LoginResponseBody.class);
        step("Проверяем ошибку Missing password", () ->
                assertEquals("Missing password", response.getError()));
    }
}
