package com.manywho.sdk.services;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class AbstractService {
    private ObjectMapper objectMapper = new ObjectMapper().enable(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING);

    protected <T> T convertToRequest(String json, Class<T> tClass) throws IllegalAccessException, InstantiationException {
        try {
            return this.objectMapper.readValue(json, tClass);
        } catch (Exception exception) {
            return tClass.newInstance();
        }
    }

//    protected AuthenticationResponse convertToAuthenticationResponse(InvokeResponse invokeResponse, AuthenticationRequest request) {
//        return new AuthenticationResponse() {{
////            inv
//        }};
//    }

//    protected ObjectDataResponse convertToObjectDataResponse(InvokeResponse invokeResponse, ObjectDataRequest request) {
//        return new ObjectDataResponse() {{
//            setCulture(request.getCulture());
//            setObjectData(new ObjectCollection());
//            setHasMoreResults(false);
//        }};
//    }
//
//    protected ServiceResponse convertToServiceResponse(InvokeResponse invokeResponse, ServiceRequest request) {
//        return new ServiceResponse() {{
//            setToken(request.getToken());
//            setInvokeType(invokeResponse.getInvokeType().toString());
//            setOutputs(new EngineValueCollection() {{
//                addAll(invokeResponse.getOutputs().stream().map(AbstractService.this::getEngineValue).collect(Collectors.toList()));
//            }});
//        }};
//    }

//    private EngineValue getEngineValue(InvokeResponseOutput invokeResponseOutput) {
//        EngineValue engineValue = new EngineValue();
//        engineValue.setContentType(invokeResponseOutput.getContentType());
//        engineValue.setDeveloperName(invokeResponseOutput.getName());
//
//        switch (invokeResponseOutput.getContentType()) {
//            case Object:
//                if (invokeResponseOutput.getValue() instanceof ServiceObjectInterface) {
//                    com.manywho.sdk.entities.Object serviceObject = ((ServiceObjectInterface) invokeResponseOutput.getValue()).convertToObject();
//
//                    engineValue.setTypeElementDeveloperName(serviceObject.getDeveloperName());
//                    engineValue.setObjectData(new ObjectCollection() {{
//                        add(serviceObject);
//                    }});
//
//                    return engineValue;
//                }
//                break;
//            case List:
//                // @todo Not sure I like this... try and make it a bit more efficient
//                if (invokeResponseOutput.getValue() instanceof Collection) {
//                    ArrayList<ServiceObjectInterface> objects = (ArrayList<ServiceObjectInterface>) invokeResponseOutput.getValue();
//
//                    engineValue.setTypeElementDeveloperName(objects.get(0).convertToObject().getDeveloperName());
//                    engineValue.setObjectData(new ObjectCollection() {{
//                        for (ServiceObjectInterface object : objects) {
//                            add(object.convertToObject());
//                        }
//                    }});
//
//                    return engineValue;
//                }
//                break;
//            default:
//                if (invokeResponseOutput.getValue() instanceof String) {
//                    engineValue.setContentValue(invokeResponseOutput.getValue().toString());
//
//                    return engineValue;
//                }
//                break;
//        }
//
//        return null;
//    }
}
