package com.manywho.sdk.client.mappers;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.manywho.sdk.client.exceptions.ManyWhoException;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.List;

import static com.manywho.sdk.services.providers.ObjectMapperProvider.getObjectMapper;

public class ResponseMapper {
    public static <T> T parseResponse(HttpResponse response, Class<T> responseClass) throws IOException {
        if (!isSuccessStatusCode(response.getStatusLine().getStatusCode())) {
            throw new ManyWhoException(response);
        }

        return mapResponse(response, responseClass);
    }

    public static <T> List<T> parseListResponse(HttpResponse response, Class<T> responseClass) throws IOException {
        if (!isSuccessStatusCode(response.getStatusLine().getStatusCode())) {
            throw new ManyWhoException(response);
        }

        return mapListResponse(response, responseClass);
    }

    protected static <T> T mapResponse(HttpResponse response, Class<T> responseClass) throws IOException {
        return getObjectMapper().readValue(response.getEntity().getContent(), responseClass);
    }

    protected static <T> List<T> mapListResponse(HttpResponse response, Class<T> responseClass) throws IOException {
        CollectionType type = getObjectMapper().getTypeFactory().constructCollectionType(List.class, responseClass);

        return getObjectMapper().readValue(response.getEntity().getContent(), type);
    }

    private static boolean isSuccessStatusCode(int statusCode) {
        return statusCode >= 200 && statusCode <= 299;
    }
}
