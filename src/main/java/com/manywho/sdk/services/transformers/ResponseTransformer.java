package com.manywho.sdk.services.transformers;

import com.manywho.sdk.services.ResponseProviderInterface;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class ResponseTransformer implements spark.ResponseTransformer {

    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING);

    @Override
    public String render(Object model) throws Exception {
        return objectMapper.writeValueAsString(((ResponseProviderInterface) model).createResponse());
    }
}
