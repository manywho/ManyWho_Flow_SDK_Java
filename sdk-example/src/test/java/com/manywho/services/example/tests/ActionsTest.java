package com.manywho.services.example.tests;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ActionsTest {
    @Test
    public void testAddAnnotationCommand() {
        ServiceRequest serviceRequest = new ServiceRequest();

        given()
                .contentType(ContentType.JSON)
                .body(serviceRequest)
                .when()
                .post("/actions/addannotation")
                .then()
                .assertThat()
                .statusCode(200)
                .body("invokeType", equalTo("FORWARD"))
                .body("outputs", hasSize(1))
                .body("outputs[0].contentType", equalTo("ContentDateTime"))
                .body("outputs[0].contentValue", startsWith(LocalDate.now().format(DateTimeFormatter.ISO_DATE)))
                .body("outputs[0].developerName", equalTo("Created At"))
                .body("outputs[0].objectData", hasSize(0));
    }
}
