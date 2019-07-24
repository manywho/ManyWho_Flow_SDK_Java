package com.manywho.services.example;

import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DatabaseLoadTest extends FunctionalTest {
    @Test
    public void testFindAll() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("Person");

        ListFilter listFilter = new ListFilter();
        listFilter.setLimit(2);

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setListFilter(listFilter);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .post("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(2))
                .body("objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].externalId", not(isEmptyOrNullString()))
                .body("objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("objectData[0].properties[0].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[0].developerName", equalTo("Age"))
                .body("objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("objectData[0].properties[1].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[1].developerName", equalTo("Biography"))
                .body("objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[2].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[2].developerName", equalTo("Created At"))
                .body("objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("objectData[0].properties[3].contentValue", nullValue())
                .body("objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("objectData[0].properties[3].objectData", hasSize(2))
                .body("objectData[0].properties[3].objectData[0].developerName", equalTo("Group"))
                .body("objectData[0].properties[3].objectData[0].externalId", equalTo("1"))
                .body("objectData[0].properties[3].objectData[0].properties", hasSize(1))
                .body("objectData[0].properties[3].objectData[0].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[3].objectData[0].properties[0].contentValue", equalTo("Developers"))
                .body("objectData[0].properties[3].objectData[0].properties[0].developerName", equalTo("Name"))
                .body("objectData[0].properties[3].objectData[1].developerName", equalTo("Group"))
                .body("objectData[0].properties[3].objectData[1].externalId", equalTo("2"))
                .body("objectData[0].properties[3].objectData[1].properties", hasSize(1))
                .body("objectData[0].properties[3].objectData[1].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[3].objectData[1].properties[0].contentValue", equalTo("TechOps"))
                .body("objectData[0].properties[3].objectData[1].properties[0].developerName", equalTo("Name"))
                .body("objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("objectData[0].properties[4].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[4].developerName", equalTo("Is Active?"))

                .body("objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("objectData[0].properties[5].contentValue", nullValue())
                .body("objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("objectData[0].properties[5].objectData", hasSize(1))
                .body("objectData[0].properties[5].objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].properties[5].objectData[0].externalId", not(isEmptyOrNullString()))
                .body("objectData[0].properties[5].objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[5].objectData[0].properties[3].objectData", hasSize(2))

                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[6].developerName", equalTo("Name"))

                .body("objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("objectData[0].properties[7].contentValue", nullValue())
                .body("objectData[0].properties[7].developerName", equalTo("Password"))

                .body("objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("objectData[0].properties[8].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[8].developerName", equalTo("Social Security Number"));
    }

    @Test
    public void testFind() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("Person");

        ListFilter listFilter = new ListFilter();
        listFilter.setId(UUID.randomUUID().toString());

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setListFilter(listFilter);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .post("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(1))
                .body("objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].externalId", not(isEmptyOrNullString()))
                .body("objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("objectData[0].properties[0].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[0].developerName", equalTo("Age"))
                .body("objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("objectData[0].properties[1].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[1].developerName", equalTo("Biography"))
                .body("objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("objectData[0].properties[2].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[2].developerName", equalTo("Created At"))
                .body("objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("objectData[0].properties[3].contentValue", nullValue())
                .body("objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("objectData[0].properties[3].objectData", hasSize(2))
                .body("objectData[0].properties[3].objectData[0].developerName", equalTo("Group"))
                .body("objectData[0].properties[3].objectData[0].externalId", equalTo("1"))
                .body("objectData[0].properties[3].objectData[0].properties", hasSize(1))
                .body("objectData[0].properties[3].objectData[0].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[3].objectData[0].properties[0].contentValue", equalTo("Developers"))
                .body("objectData[0].properties[3].objectData[0].properties[0].developerName", equalTo("Name"))
                .body("objectData[0].properties[3].objectData[1].developerName", equalTo("Group"))
                .body("objectData[0].properties[3].objectData[1].externalId", equalTo("2"))
                .body("objectData[0].properties[3].objectData[1].properties", hasSize(1))
                .body("objectData[0].properties[3].objectData[1].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[3].objectData[1].properties[0].contentValue", equalTo("TechOps"))
                .body("objectData[0].properties[3].objectData[1].properties[0].developerName", equalTo("Name"))
                .body("objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("objectData[0].properties[4].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[4].developerName", equalTo("Is Active?"))

                .body("objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("objectData[0].properties[5].contentValue", nullValue())
                .body("objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("objectData[0].properties[5].objectData", hasSize(1))
                .body("objectData[0].properties[5].objectData[0].developerName", equalTo("Person"))
                .body("objectData[0].properties[5].objectData[0].externalId", not(isEmptyOrNullString()))
                .body("objectData[0].properties[5].objectData[0].properties", hasSize(9))
                .body("objectData[0].properties[5].objectData[0].properties[3].objectData", hasSize(2))

                .body("objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[6].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[6].developerName", equalTo("Name"))

                .body("objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("objectData[0].properties[7].contentValue", nullValue())
                .body("objectData[0].properties[7].developerName", equalTo("Password"))

                .body("objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("objectData[0].properties[8].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[8].developerName", equalTo("Social Security Number"));
    }

    @Test
    public void testFindAllRaw() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("custom-type-one");

        ListFilter listFilter = new ListFilter();
        listFilter.setLimit(2);

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setListFilter(listFilter);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .post("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("objectData", hasSize(2))
                .body("objectData[0].developerName", equalTo("custom-type-one"))
                .body("objectData[0].externalId", equalTo("0"))
                .body("objectData[0].properties", hasSize(2))
                .body("objectData[0].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[0].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[0].developerName", equalTo("Property One"))
                .body("objectData[0].properties[1].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[1].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[1].developerName", equalTo("Property Two"))

                .body("objectData[1].developerName", equalTo("custom-type-one"))
                .body("objectData[1].externalId", equalTo("1"))
                .body("objectData[1].properties", hasSize(2))
                .body("objectData[1].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[0].contentValue", not(isEmptyOrNullString()))
                .body("objectData[1].properties[0].developerName", equalTo("Property One"))
                .body("objectData[1].properties[1].contentType", equalTo("ContentString"))
                .body("objectData[1].properties[1].contentValue", not(isEmptyOrNullString()))
                .body("objectData[1].properties[1].developerName", equalTo("Property Two"));
    }

    @Test
    public void testFindRaw() {
        List<EngineValue> configurationValues = new ArrayList<>();
        configurationValues.add(new EngineValue("Username",  com.manywho.sdk.api.ContentType.String, "username-test"));
        configurationValues.add(new EngineValue("Password",  com.manywho.sdk.api.ContentType.String, "password-test"));

        ObjectDataType objectDataType = new ObjectDataType();
        objectDataType.setDeveloperName("custom-type-one");

        ListFilter listFilter = new ListFilter();
        listFilter.setId(UUID.randomUUID().toString());

        ObjectDataRequest objectDataRequest = new ObjectDataRequest();
        objectDataRequest.setObjectDataType(objectDataType);
        objectDataRequest.setListFilter(listFilter);
        objectDataRequest.setConfigurationValues(configurationValues);

        given()
                .contentType(ContentType.JSON)
                .body(objectDataRequest)
                .when()
                .post("/data")
                .then()
                .assertThat()
                .statusCode(200)
                .body(notNullValue())
                .body("hasMoreResults", equalTo(false))
                .body("objectData", hasSize(1))
                .body("objectData[0].developerName", equalTo("custom-type-one"))
                .body("objectData[0].externalId", equalTo(listFilter.getId()))
                .body("objectData[0].properties", hasSize(2))
                .body("objectData[0].properties[0].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[0].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[0].developerName", equalTo("Property One"))
                .body("objectData[0].properties[1].contentType", equalTo("ContentString"))
                .body("objectData[0].properties[1].contentValue", not(isEmptyOrNullString()))
                .body("objectData[0].properties[1].developerName", equalTo("Property Two"));
    }
}
