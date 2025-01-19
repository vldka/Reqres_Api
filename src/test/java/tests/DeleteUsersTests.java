package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BaseSpec.getResponseSpecification;
import static specs.BaseSpec.requestSpec;

@Tag("API-TEST")
@DisplayName("Тестирование Delete")
public class DeleteUsersTests extends TestBase {

    @Test
    @Tag("API-TEST")
    @DisplayName("Проверка Api Delete User")
    public void deleteRequestSuccefullTest() {
        step("Проверяем успешное удаление с кодом 204", () ->
                given(requestSpec)
                        .when()
                        .delete("users/2")
                        .then()
                        .spec(getResponseSpecification(204))
        );
    }
}
