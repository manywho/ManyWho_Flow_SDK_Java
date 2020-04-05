package com.manywho.services.example.tests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HealthTest {
    @Test
    public void testHealthCheck() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/health")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
