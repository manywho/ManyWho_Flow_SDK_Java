package com.manywho.sdk.services.utils;

import java.util.UUID;

public class UUIDs {
    public static boolean isValid(String value) {
        return value != null && value.trim().matches("[0-9a-f]{8}-([0-9a-f]{4}-){3}[0-9a-f]{12}");
    }

    public static UUID uuidFromNullableString(String value) {
        if (value == null) {
            return null;
        }

        return UUID.fromString(value);
    }
}
