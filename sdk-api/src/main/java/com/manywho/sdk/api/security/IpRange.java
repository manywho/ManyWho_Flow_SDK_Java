package com.manywho.sdk.api.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class IpRange {
    private String developerName;
    private String developerSummary;
    private InetAddress startIPAddress;
    private InetAddress endIPAddress;
}
