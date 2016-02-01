package com.manywho.sdk.exceptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException() {
        super("The username or password you have entered is invalid");
    }
}
