package com.manywho.sdk.enums;

public enum StatusCode {
    Unauthorized("401"),
    Ok("200");

    private final String text;

    private StatusCode(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public static StatusCode fromString(String text) {
        if(text != null) {
            StatusCode[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                StatusCode statusCode = var1[var3];
                if(text.equalsIgnoreCase(statusCode.text)) {
                    return statusCode;
                }
            }
        }

        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}