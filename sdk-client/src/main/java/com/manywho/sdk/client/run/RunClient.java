package com.manywho.sdk.client.run;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineInitializationRequest;
import com.manywho.sdk.api.run.EngineInitializationResponse;
import com.manywho.sdk.api.run.EngineInvokeRequest;
import com.manywho.sdk.api.run.EngineInvokeResponse;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.UUID;

public interface RunClient {
    @POST("api/run/1/state/{id}")
    Call<EngineInvokeResponse> execute(
            @Header("ManyWhoTenant") String tenant,
            @Path("id") String id,
            @Body EngineInvokeRequest request
    );

    @POST("api/run/1/state/{id}")
    Call<EngineInvokeResponse> execute(
            @Header("ManyWhoTenant") UUID tenant,
            @Path("id") UUID id,
            @Body EngineInvokeRequest request
    );

    @POST("api/run/1/state/{id}")
    Call<EngineInvokeResponse> execute(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Path("id") UUID id,
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

    @GET("api/run/1/state/{id}")
    Call<EngineInvokeResponse> join(
            @Header("ManyWhoTenant") String tenant,
            @Path("id") String id
    );

    @GET("api/run/1/state/{id}")
    Call<EngineInvokeResponse> join(
            @Header("ManyWhoTenant") UUID tenant,
            @Path("id") UUID id
    );

    @GET("api/run/1/state/{id}")
    Call<EngineInvokeResponse> join(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Path("id") UUID id
    );

    @POST("api/run/1/response")
    Call<InvokeType> callback(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Body ServiceResponse response
    );
}
