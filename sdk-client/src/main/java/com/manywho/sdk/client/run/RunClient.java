package com.manywho.sdk.client.run;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineInitializationRequest;
import com.manywho.sdk.api.run.EngineInitializationResponse;
import com.manywho.sdk.api.run.EngineInvokeRequest;
import com.manywho.sdk.api.run.EngineInvokeResponse;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.api.security.AuthenticationCredentials;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.UUID;

public interface RunClient {
    @POST("api/run/1/state/{state}")
    Call<EngineInvokeResponse> execute(
            @Header("ManyWhoTenant") String tenant,
            @Path("state") String state,
            @Body EngineInvokeRequest request
    );

    @POST("api/run/1/state/{state}")
    Call<EngineInvokeResponse> execute(
            @Header("ManyWhoTenant") UUID tenant,
            @Path("state") UUID state,
            @Body EngineInvokeRequest request
    );

    @POST("api/run/1/state/{state}")
    Call<EngineInvokeResponse> execute(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Path("state") UUID state,
            @Body EngineInvokeRequest request
    );

    @POST("api/run/1")
    Call<EngineInitializationResponse> initialize(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") String tenant,
            @Body EngineInitializationRequest initialization
    );

    @POST("api/run/1")
    Call<EngineInitializationResponse> initialize(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Body EngineInitializationRequest initialization
    );

    @GET("api/run/1/state/{state}")
    Call<EngineInvokeResponse> join(
            @Header("ManyWhoTenant") String tenant,
            @Path("state") String state
    );

    @GET("api/run/1/state/{state}")
    Call<EngineInvokeResponse> join(
            @Header("ManyWhoTenant") UUID tenant,
            @Path("state") UUID state
    );

    @GET("api/run/1/state/{state}")
    Call<EngineInvokeResponse> join(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Path("state") UUID state
    );

    @POST("api/run/1/response")
    Call<InvokeType> callback(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Body ServiceResponse response
    );

    @POST("api/run/1/authentication/{state}")
    Call<String> authentication(
            @Header("ManyWhoTenant") UUID tenant,
            @Path("state") UUID state,
            @Body AuthenticationCredentials authenticationCredentials
    );
}
