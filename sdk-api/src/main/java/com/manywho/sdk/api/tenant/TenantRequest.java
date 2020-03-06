package com.manywho.sdk.api.tenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TenantRequest {
    private String developerSummary;
    private ReportSettings reportSettings;
    private SecuritySettings securitySettings;
    private StateSettings stateSettings;
    private String subdomain;
    private TenantSettings tenantSettings;
}
