package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.inject.Provider;
//import com.google.inject.servlet.RequestScoped;
import com.manywho.sdk.api.security.AuthenticatedWho;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//@RequestScoped
public class AuthenticatedWhoProvider implements Provider<AuthenticatedWho> {
    private final HttpHeaders headers;
    private final ObjectMapper objectMapper;

    @Inject
    public AuthenticatedWhoProvider(HttpHeaders headers, ObjectMapper objectMapper) {
        this.headers = headers;
        this.objectMapper = objectMapper;
    }

    @Override
    public AuthenticatedWho get() {
        String authorizationHeader = headers.getRequestHeaders().getFirst("Authorization");
        if (authorizationHeader == null) {
            // TODO: Throw unauthorized exception?
            return null;
        }

        String decodedHeader;

        try {
            decodedHeader = URLDecoder.decode(authorizationHeader, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to deserialize the incoming AuthenticatedWho", e);
        }

//        Map<String, String> pairs = Splitter.on('&')
//                .trimResults()
//                .withKeyValueSeparator('=')
//                .split(decodedHeader)
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(
//                        entry -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, entry.getKey()),
//                        entry -> entry.getValue()
//                ));

        Map<String, String> pairs = URLEncodedUtils.parse(decodedHeader, Charsets.UTF_8)
                .stream()
                .map(pair -> new BasicNameValuePair(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, pair.getName()), pair.getValue()))
                .collect(Collectors.toMap(
                        entry -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, entry.getName()),
                        entry -> entry.getValue()
                ));

//        Map<String, String> pairs = getQueryMap(decodedHeader)
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(
//                        entry -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, entry.getKey()),
//                        entry -> entry.getValue()
//                ));

        return objectMapper.convertValue(pairs, AuthenticatedWho.class);
    }

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
