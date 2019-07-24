package com.manywho.services.example;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.type.*;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DatabaseDeleteTest extends FunctionalTest {
    @Test
    public void testDelete() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("Person");

        List<Property> properties = new ArrayList<>();
        properties.add(new Property("Age", 123));
        properties.add(new Property("Biography", "some biography"));
        properties.add(new Property("Created At", OffsetDateTime.now()));
        properties.add(new Property("Groups", new ArrayList<>()));
        properties.add(new Property("Is Active?", true));
        properties.add(new Property("Name", "some name"));
        properties.add(new Property("Password", "password1234"));
        properties.add(new Property("Social Security Number", "12345-67890"));

        List<MObject> objects = new ArrayList<>();
        objects.add(new MObject("Person", UUID.randomUUID().toString(), properties));

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setObjectData(objects);
        objectDataRequest.setConfigurationValues(configurationValues);
        // TODO: This only really tests that the path doesn't error, not that it actually calls "delete"
        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .post("/data/delete")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("hasMoreResults", equalTo(false))
                .body("objectData", hasSize(0));
    }

    @Test
    public void testDeleteRaw() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  ContentType.String, "password-test"));


        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("custom-type-one");

        List<Property> properties = new ArrayList<>();
        properties.add(new Property("Property One", "some property one"));
        properties.add(new Property("Property Two", "some property two"));

        List<MObject> objects = new ArrayList<>();
        objects.add(new MObject("custom-type-one", UUID.randomUUID().toString(), properties));

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setObjectData(objects);
        objectDataRequest.setConfigurationValues(configurationValues);

        // TODO: This only really tests that the path doesn't error, not that it actually calls "delete"
        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .post("/data/delete")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("hasMoreResults", equalTo(false))
                .body("objectData", hasSize(0));
    }
}
