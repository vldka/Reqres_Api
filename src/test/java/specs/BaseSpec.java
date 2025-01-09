package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.http.ContentType.JSON;

public class BaseSpec {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setContentType(JSON)
            .addFilter(withCustomTemplates())
            .log(LogDetail.URI)
            .log(LogDetail.HEADERS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification getResponseSpecification(int responseCode) {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(responseCode)
                .build();
        return responseSpec;
    }

}
