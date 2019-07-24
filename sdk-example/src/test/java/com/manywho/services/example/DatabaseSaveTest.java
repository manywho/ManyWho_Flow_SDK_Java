package com.manywho.services.example;

import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.api.run.elements.type.Property;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DatabaseSaveTest extends FunctionalTest {
    @Test
    public void testCreate() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

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
        objects.add(new MObject("Person", properties));

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setObjectData(objects);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .put("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(1))
                .body("objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].externalId", not(isEmptyOrNullString()))
                .body("objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("objectData[0].properties[0].contentValue", equalTo("123"))
                .body("objectData[0].properties[0].developerName", equalTo("Age"))

                .body("objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("objectData[0].properties[1].contentValue", equalTo("some biography"))
                .body("objectData[0].properties[1].developerName", equalTo("Biography"))

                .body("objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[2].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[2].developerName", equalTo("Created At"))

                .body("objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("objectData[0].properties[3].contentValue", nullValue())
                .body("objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("objectData[0].properties[3].objectData", hasSize(0))

                .body("objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("objectData[0].properties[4].contentValue", equalTo("true"))
                .body("objectData[0].properties[4].developerName", equalTo("Is Active?"))

                .body("objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("objectData[0].properties[5].contentValue", nullValue())
                .body("objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("objectData[0].properties[5].objectData", hasSize(0))

                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].contentValue", equalTo("some name"))
                .body("objectData[0].properties[6].developerName", equalTo("Name"))

                .body("objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("objectData[0].properties[7].contentValue", nullValue())
                .body("objectData[0].properties[7].developerName", equalTo("Password"))

                .body("objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("objectData[0].properties[8].contentValue", equalTo("12345-67890"))
                .body("objectData[0].properties[8].developerName", equalTo("Social Security Number"));
    }

    @Test
    public void testCreateMultiple() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

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
        objects.add(new MObject("Person", properties));
        objects.add(new MObject("Person", properties));

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setObjectData(objects);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .put("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(2))
                .body("objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].externalId", not(isEmptyOrNullString()))
                .body("objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("objectData[0].properties[0].contentValue", equalTo("123"))
                .body("objectData[0].properties[0].developerName", equalTo("Age"))

                .body("objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("objectData[0].properties[1].contentValue", equalTo("some biography"))
                .body("objectData[0].properties[1].developerName", equalTo("Biography"))

                .body("objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[2].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[2].developerName", equalTo("Created At"))

                .body("objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("objectData[0].properties[3].contentValue", nullValue())
                .body("objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("objectData[0].properties[3].objectData", hasSize(0))

                .body("objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("objectData[0].properties[4].contentValue", equalTo("true"))
                .body("objectData[0].properties[4].developerName", equalTo("Is Active?"))

                .body("objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("objectData[0].properties[5].contentValue", nullValue())
                .body("objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("objectData[0].properties[5].objectData", hasSize(0))

                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].contentValue", equalTo("some name"))
                .body("objectData[0].properties[6].developerName", equalTo("Name"))

                .body("objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("objectData[0].properties[7].contentValue", nullValue())
                .body("objectData[0].properties[7].developerName", equalTo("Password"))

                .body("objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("objectData[0].properties[8].contentValue", equalTo("12345-67890"))
                .body("objectData[0].properties[8].developerName", equalTo("Social Security Number"));
    }

    @Test
    public void testUpdate() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("Person");

        String id = UUID.randomUUID().toString();

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
        objects.add(new MObject("Person", id, properties));

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setObjectData(objects);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .put("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(1))
                .body("objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].externalId", equalTo(id))
                .body("objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("objectData[0].properties[0].contentValue", equalTo("123"))
                .body("objectData[0].properties[0].developerName", equalTo("Age"))

                .body("objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("objectData[0].properties[1].contentValue", equalTo("some biography"))
                .body("objectData[0].properties[1].developerName", equalTo("Biography"))

                .body("objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[2].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[2].developerName", equalTo("Created At"))

                .body("objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("objectData[0].properties[3].contentValue", nullValue())
                .body("objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("objectData[0].properties[3].objectData", hasSize(0))

                .body("objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("objectData[0].properties[4].contentValue", equalTo("true"))
                .body("objectData[0].properties[4].developerName", equalTo("Is Active?"))

                .body("objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("objectData[0].properties[5].contentValue", nullValue())
                .body("objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("objectData[0].properties[5].objectData", hasSize(0))

                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].contentValue", equalTo("some name"))
                .body("objectData[0].properties[6].developerName", equalTo("Name"))

                .body("objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("objectData[0].properties[7].contentValue", nullValue())
                .body("objectData[0].properties[7].developerName", equalTo("Password"))

                .body("objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("objectData[0].properties[8].contentValue", equalTo("12345-67890"))
                .body("objectData[0].properties[8].developerName", equalTo("Social Security Number"));
    }

    @Test
    public void testUpdateMultiple() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("Person");

        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();

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
        objects.add(new MObject("Person", id1, properties));
        objects.add(new MObject("Person", id2, properties));

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setObjectData(objects);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .put("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(2))
                .body("objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].externalId", equalTo(id1))
                .body("objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("objectData[0].properties[0].contentValue", equalTo("123"))
                .body("objectData[0].properties[0].developerName", equalTo("Age"))

                .body("objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("objectData[0].properties[1].contentValue", equalTo("some biography"))
                .body("objectData[0].properties[1].developerName", equalTo("Biography"))

                .body("objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[2].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[2].developerName", equalTo("Created At"))

                .body("objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("objectData[0].properties[3].contentValue", nullValue())
                .body("objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("objectData[0].properties[3].objectData", hasSize(0))

                .body("objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("objectData[0].properties[4].contentValue", equalTo("true"))
                .body("objectData[0].properties[4].developerName", equalTo("Is Active?"))

                .body("objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("objectData[0].properties[5].contentValue", nullValue())
                .body("objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("objectData[0].properties[5].objectData", hasSize(0))

                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].contentValue", equalTo("some name"))
                .body("objectData[0].properties[6].developerName", equalTo("Name"))

                .body("objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("objectData[0].properties[7].contentValue", nullValue())
                .body("objectData[0].properties[7].developerName", equalTo("Password"))

                .body("objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("objectData[0].properties[8].contentValue", equalTo("12345-67890"))
                .body("objectData[0].properties[8].developerName", equalTo("Social Security Number"));
    }
}
