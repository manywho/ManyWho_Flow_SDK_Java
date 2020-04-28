package com.manywho.sdk.client.run;

import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Provider;

public class RunClientProvider implements Provider<RunClient> {
    @Override
    public RunClient get() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapperFactory.create()))
                .baseUrl("https://flow.manywho.com")
                .build();

        return retrofit.create(RunClient.class);
    }
}
