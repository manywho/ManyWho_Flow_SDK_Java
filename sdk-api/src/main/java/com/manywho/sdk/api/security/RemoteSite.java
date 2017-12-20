package com.manywho.sdk.api.security;

import lombok.Data;

@Data
public class RemoteSite {
    private String developerName;
    private String developerSummary;
    private Boolean disableProtocolSecurity;
    private String uri;
}
