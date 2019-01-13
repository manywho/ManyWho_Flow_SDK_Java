package com.manywho.sdk.services.servers.lambda;

import com.manywho.sdk.api.security.AuthenticatedWho;

public class LambdaContext {
    private static ThreadLocal<AuthenticatedWho> user = new ThreadLocal<>();

    public static AuthenticatedWho getUser() {
        return user.get();
    }

    public static void setUser(AuthenticatedWho user) {
        LambdaContext.user.set(user);
    }
}
