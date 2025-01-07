package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.http.ContentType.JSON;

public class BaseSpec {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setContentType(JSON)
            .addFilter(withCustomTemplates())
            .log(LogDetail.ALL)
            .build();
}
