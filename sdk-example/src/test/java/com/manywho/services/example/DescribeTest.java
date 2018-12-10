package com.manywho.services.example;

import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DescribeTest extends FunctionalTest {
    @Test
    public void testDescribe() {
        DescribeServiceRequest request = new DescribeServiceRequest();

        DescribeServiceResponse response = given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/metadata")
                .as(DescribeServiceResponse.class);

        assertNotNull(response);
        assertNotNull(response.getConfigurationValues());
        assertThat(response.getConfigurationValues(), hasSize(2));
    }
}
