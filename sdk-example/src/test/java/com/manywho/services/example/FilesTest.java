package com.manywho.services.example;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import org.junit.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class FilesTest extends FunctionalTest {
    @Test
    public void testUploadFile() {
        ObjectDataResponse response = given()
                .multiPart("fileDataRequest", new FileDataRequest(), "application/json")
                .multiPart("fileContent", UUID.randomUUID(), "application/octet-stream")
                .when()
                .post("/file/content")
                .as(ObjectDataResponse.class);

        assertNotNull(response);
        assertNotNull(response.getObjectData());
        assertThat(response.getObjectData(), hasSize(1));
    }
}
