package com.manywho.sdk.services.utils;

public class UUIDs {
    public static boolean isValid(String value) {
        return value != null && value.trim().matches("/^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/");
    }
}
