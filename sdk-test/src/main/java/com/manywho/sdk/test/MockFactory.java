package com.manywho.sdk.test;

import org.glassfish.hk2.api.Factory;

public class MockFactory<T> implements Factory<T> {

    private T instance;

    public MockFactory(T instance) {
        this.instance = instance;
    }

    @Override
    public T provide() {
        return instance;
    }

    @Override
    public void dispose(T t) {

    }
}
