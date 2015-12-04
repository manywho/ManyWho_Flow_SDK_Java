package com.manywho.sdk.test;

import com.google.common.io.Resources;
import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.services.providers.ObjectMapperProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class FunctionalTest extends JerseyTest
{
    @Override
    protected void configureClient(ClientConfig config) {
        config.register(ObjectMapperProvider.class);
    }

    protected File getFile(String fileResourcePath) throws URISyntaxException {
        return new File(Resources.getResource(fileResourcePath).toURI());
    }

    protected String getJsonFormatFileContent(String filePath) throws FileNotFoundException, URISyntaxException, JSONException {
        return getJsonFormat(new Scanner(getFile(filePath)).useDelimiter("\\Z").next());
    }

    protected String getJsonFormatResponse(Response notFormatedJsonResponse) throws JSONException {
        return getJsonFormat(notFormatedJsonResponse.readEntity(String.class));
    }

    protected String getJsonFormat(String notFormatString) throws JSONException {
        return new JSONObject(notFormatString).toString(4);
    }

    protected void assertJsonSame(String expected, String actual) throws JSONException {
        JSONAssert.assertEquals(expected, actual, false);
    }

    protected Entity<ServiceRequest> getServerRequestFromFile(String filePath) throws URISyntaxException, IOException {
        ServiceRequest serviceRequest = ObjectMapperProvider
                .getObjectMapper()
                .readValue(
                        getFile(filePath),
                        ServiceRequest.class
                );

        return Entity.entity(serviceRequest, MediaType.APPLICATION_JSON_TYPE);
    }

    protected AuthenticatedWho getDefaultAuthenticatedWho() {

        AuthenticatedWho authenticatedWho = new AuthenticatedWho();
        authenticatedWho.setManyWhoTenantId("67204d5c-6022-474d-8f80-0d576b43d02d");
        authenticatedWho.setManyWhoUserId("52df1a90-3826-4508-b7c2-cde8aa5b72cf");
        authenticatedWho.setManyWhoToken("the-token");
        authenticatedWho.setDirectoryId("UNAUTHENTICATED");
        authenticatedWho.setDirectoryName("UNKNOWN");
        authenticatedWho.setEmail("admin@manywho.com");
        authenticatedWho.setIdentityProvider("NONE");
        authenticatedWho.setTenantName("UNKNOWN");
        authenticatedWho.setToken("NONE");
        authenticatedWho.setUsername("");
        authenticatedWho.setUserId("PUBLIC_USER");
        authenticatedWho.setFirstName("");
        authenticatedWho.setLastName("");

        return authenticatedWho;
    }
}
