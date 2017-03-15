//package com.manywho.sdk.services.identity.providers;
//
//import com.github.scribejava.core.builder.ServiceBuilder;
//import com.github.scribejava.core.oauth.OAuth20Service;
//import com.google.inject.Provider;
//import com.manywho.sdk.services.identity.AbstractOauth2;
//
//import javax.inject.Inject;
//
//public class ScribeOauth2Provider implements Provider<OAuth20Service> {
//    private final AbstractOauth2 oauth2;
//
//    @Inject
//    public ScribeOauth2Provider(AbstractOauth2 oauth2) {
//        this.oauth2 = oauth2;
//    }
//
//    @Override
//    public OAuth20Service get() {
//        return new ServiceBuilder()
//                .apiKey(oauth2.getClientId())
//                .apiSecret(oauth2.getClientSecret())
//                .callback(oauth2.getCallbackUri())
//                .scope(oauth2.getScope())
//                .build(oauth2);
//    }
//}
