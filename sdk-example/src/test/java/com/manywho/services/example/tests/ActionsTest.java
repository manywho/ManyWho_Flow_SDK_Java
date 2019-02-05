package com.manywho.services.example.tests;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static java.time.format.DateTimeFormatter.ISO_DATE;
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
                .body("outputs", hasSize(3))
                .body("outputs[0].contentType", equalTo("ContentString"))
                .body("outputs[0].contentValue", equalTo("This is a test annotation"))
                .body("outputs[0].developerName", equalTo("Annotation"))
                .body("outputs[0].objectData", hasSize(0))

                .body("outputs[1].contentType", equalTo("ContentDateTime"))
                .body("outputs[1].contentValue", startsWith(LocalDate.now().format(ISO_DATE)))
                .body("outputs[1].developerName", equalTo("Created At"))
                .body("outputs[1].objectData", hasSize(0))

                .body("outputs[2].contentType", equalTo("ContentObject"))
                .body("outputs[2].contentValue", notNullValue())
                .body("outputs[2].developerName", equalTo("Person"))
                .body("outputs[2].objectData", hasSize(1))
                .body("outputs[2].objectData[0].developerName", equalTo("Person"))
                .body("outputs[2].objectData[0].externalId", equalTo("801-28-6595"))
                .body("outputs[2].objectData[0].properties", hasSize(9))
                .body("outputs[2].objectData[0].properties[0].contentType", equalTo("ContentNumber"))
                .body("outputs[2].objectData[0].properties[0].contentValue", equalTo("38"))
                .body("outputs[2].objectData[0].properties[0].developerName", equalTo("Age"))
                .body("outputs[2].objectData[0].properties[0].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[1].contentType", equalTo("ContentContent"))
                .body("outputs[2].objectData[0].properties[1].contentValue", notNullValue())
                .body("outputs[2].objectData[0].properties[1].developerName", equalTo("Biography"))
                .body("outputs[2].objectData[0].properties[1].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[2].contentType", equalTo("ContentDateTime"))
                .body("outputs[2].objectData[0].properties[2].contentValue", startsWith(LocalDate.now().format(ISO_DATE)))
                .body("outputs[2].objectData[0].properties[2].developerName", equalTo("Created At"))
                .body("outputs[2].objectData[0].properties[2].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[3].contentType", equalTo("ContentList"))
                .body("outputs[2].objectData[0].properties[3].contentValue", nullValue())
                .body("outputs[2].objectData[0].properties[3].developerName", equalTo("Groups"))
                .body("outputs[2].objectData[0].properties[3].objectData", hasSize(2))
                .body("outputs[2].objectData[0].properties[3].objectData[0].developerName", equalTo("Group"))
                .body("outputs[2].objectData[0].properties[3].objectData[0].externalId", equalTo("1"))
                .body("outputs[2].objectData[0].properties[3].objectData[0].properties", hasSize(1))
                .body("outputs[2].objectData[0].properties[3].objectData[0].properties[0].contentType", equalTo("ContentString"))
                .body("outputs[2].objectData[0].properties[3].objectData[0].properties[0].contentValue", equalTo("Developers"))
                .body("outputs[2].objectData[0].properties[3].objectData[0].properties[0].developerName", equalTo("Name"))
                .body("outputs[2].objectData[0].properties[3].objectData[0].properties[0].objectData", hasSize(0))
                .body("outputs[2].objectData[0].properties[3].objectData[1].developerName", equalTo("Group"))
                .body("outputs[2].objectData[0].properties[3].objectData[1].externalId", equalTo("2"))
                .body("outputs[2].objectData[0].properties[3].objectData[1].properties", hasSize(1))
                .body("outputs[2].objectData[0].properties[3].objectData[1].properties[0].contentType", equalTo("ContentString"))
                .body("outputs[2].objectData[0].properties[3].objectData[1].properties[0].contentValue", equalTo("TechOps"))
                .body("outputs[2].objectData[0].properties[3].objectData[1].properties[0].developerName", equalTo("Name"))
                .body("outputs[2].objectData[0].properties[3].objectData[1].properties[0].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[4].contentType", equalTo("ContentBoolean"))
                .body("outputs[2].objectData[0].properties[4].contentValue", equalTo("true"))
                .body("outputs[2].objectData[0].properties[4].developerName", equalTo("Is Active?"))
                .body("outputs[2].objectData[0].properties[4].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[5].contentType", equalTo("ContentObject"))
                .body("outputs[2].objectData[0].properties[5].contentValue", nullValue())
                .body("outputs[2].objectData[0].properties[5].developerName", equalTo("Manager"))
                .body("outputs[2].objectData[0].properties[5].objectData", hasSize(1))
                .body("outputs[2].objectData[0].properties[5].objectData[0].developerName", equalTo("Person"))
                .body("outputs[2].objectData[0].properties[5].objectData[0].externalId", equalTo("093-87-1985"))
                .body("outputs[2].objectData[0].properties[5].objectData[0].properties", hasSize(9))

                .body("outputs[2].objectData[0].properties[6].contentType", equalTo("ContentString"))
                .body("outputs[2].objectData[0].properties[6].contentValue", not(isEmptyOrNullString()))
                .body("outputs[2].objectData[0].properties[6].developerName", equalTo("Name"))
                .body("outputs[2].objectData[0].properties[6].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[7].contentType", equalTo("ContentPassword"))
                .body("outputs[2].objectData[0].properties[7].contentValue", nullValue())
                .body("outputs[2].objectData[0].properties[7].developerName", equalTo("Password"))
                .body("outputs[2].objectData[0].properties[7].objectData", hasSize(0))

                .body("outputs[2].objectData[0].properties[8].contentType", equalTo("ContentEncrypted"))
                .body("outputs[2].objectData[0].properties[8].contentValue", nullValue())
                .body("outputs[2].objectData[0].properties[8].developerName", equalTo("Social Security Number"))
                .body("outputs[2].objectData[0].properties[8].objectData", hasSize(0));

    }
}
