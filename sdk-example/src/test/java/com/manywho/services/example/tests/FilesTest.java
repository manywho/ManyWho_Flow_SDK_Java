package com.manywho.services.example.tests;

import com.google.common.io.Files;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class FilesTest {
    @Test
    public void testDeleteFile() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .post("/file/delete")
                .then()
                .assertThat()
                .statusCode(500)
                .body(notNullValue())
                .body("kind", equalTo("service"))
                .body("message", containsString("Deleting"))
                .body("message", containsString("supported"))
                .body("statusCode", equalTo(500))
                .body("uri", equalTo("/file/delete"));
    }

    @Test
    public void testLoadFiles() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        FileDataRequest fileDataRequest = new FileDataRequest();
        fileDataRequest.setResourcePath("a-real-path");
        fileDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(fileDataRequest)
                .when()
                .post("/file")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(2))
                .body("objectData[0].developerName", equalTo("$File"))
                .body("objectData[0].externalId", equalTo("file-1"))
                .body("objectData[0].properties", hasSize(10))
                .body("objectData[0].properties[0].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[0].developerName", equalTo("Date Created"))
                .body("objectData[0].properties[1].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[1].developerName", equalTo("Date Modified"))
                .body("objectData[0].properties[2].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[2].developerName", equalTo("Description"))
                .body("objectData[0].properties[3].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[3].developerName", equalTo("Download Uri"))
                .body("objectData[0].properties[3].contentValue", equalTo("https://example.com/file-one"))
                .body("objectData[0].properties[4].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[4].developerName", equalTo("Embed Uri"))
                .body("objectData[0].properties[5].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[5].developerName", equalTo("Icon Uri"))
                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].developerName", equalTo("Id"))
                .body("objectData[0].properties[6].contentValue", equalTo("file-1"))
                .body("objectData[0].properties[7].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[7].developerName", equalTo("Kind"))
                .body("objectData[0].properties[8].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[8].developerName", equalTo("Mime Type"))
                .body("objectData[0].properties[8].contentValue", equalTo("text/html"))
                .body("objectData[0].properties[9].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[9].developerName", equalTo("Name"))
                .body("objectData[0].properties[9].contentValue", equalTo("File One"))

                .body("objectData[1].developerName", equalTo("$File"))
                .body("objectData[1].externalId", equalTo("file-2"))
                .body("objectData[1].properties", hasSize(10))
                .body("objectData[1].properties[0].contentType", equalTo("ContentDateTime"))
                .body("objectData[1].properties[0].developerName", equalTo("Date Created"))
                .body("objectData[1].properties[1].contentType", equalTo("ContentDateTime"))
                .body("objectData[1].properties[1].developerName", equalTo("Date Modified"))
                .body("objectData[1].properties[2].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[2].developerName", equalTo("Description"))
                .body("objectData[1].properties[3].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[3].developerName", equalTo("Download Uri"))
                .body("objectData[1].properties[3].contentValue", equalTo("https://example.com/file-two"))
                .body("objectData[1].properties[4].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[4].developerName", equalTo("Embed Uri"))
                .body("objectData[1].properties[5].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[5].developerName", equalTo("Icon Uri"))
                .body("objectData[1].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[6].developerName", equalTo("Id"))
                .body("objectData[1].properties[6].contentValue", equalTo("file-2"))
                .body("objectData[1].properties[7].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[7].developerName", equalTo("Kind"))
                .body("objectData[1].properties[8].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[8].developerName", equalTo("Mime Type"))
                .body("objectData[1].properties[8].contentValue", equalTo("image/jpeg"))
                .body("objectData[1].properties[9].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[9].developerName", equalTo("Name"))
                .body("objectData[1].properties[9].contentValue", equalTo("File Two"))

                .body("hasMoreResults", equalTo(false));
    }

    @Test
    public void testUploadFile() throws IOException {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        FileDataRequest fileDataRequest = new FileDataRequest();
        fileDataRequest.setResourcePath("/tmp/" + UUID.randomUUID().toString());
        fileDataRequest.setConfigurationValues(configurationValues);
        UUID content = UUID.randomUUID();

        given()
                .multiPart("fileDataRequest", fileDataRequest, "application/json")
                .multiPart("fileContent", content, "application/octet-stream")
                .when()
                .post("/file/content")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", notNullValue())
                .body("objectData", hasSize(1));

        // Now we want to check the upload handler actually got what we sent
        File file = new File(fileDataRequest.getResourcePath());

        assertEquals("The uploaded file is different", content.toString(), Files.toString(file, StandardCharsets.UTF_8));
    }

    @Test
    public void testUploadFileWithNoFileDataRequest() {
        given()
                .multiPart("fileContent", UUID.randomUUID(), "application/octet-stream")
                .when()
                .post("/file/content")
                .then()
                .assertThat()
                .statusCode(400)
                .body(notNullValue())
                .body("kind", equalTo("service"))
                .body("message", containsString("file data request"))
                .body("message", containsString("given"))
                .body("statusCode", equalTo(400))
                .body("uri", equalTo("/file/content"));
    }

    @Test
    public void testUploadFileWithNoUploadContent() {
        given()
                .multiPart("fileDataRequest", new FileDataRequest(), "application/json")
                .when()
                .post("/file/content")
                .then()
                .assertThat()
                .statusCode(400)
                .body(notNullValue())
                .body("kind", equalTo("service"))
                .body("message", containsString("file"))
                .body("message", containsString("uploaded"))
                .body("statusCode", equalTo(400))
                .body("uri", equalTo("/file/content"));
    }
}
